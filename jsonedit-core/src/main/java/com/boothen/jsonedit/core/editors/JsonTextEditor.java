package com.boothen.jsonedit.core.editors;

import java.util.HashMap;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.DefaultCharacterPairMatcher;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.projection.ProjectionAnnotation;
import org.eclipse.jface.text.source.projection.ProjectionAnnotationModel;
import org.eclipse.jface.text.source.projection.ProjectionSupport;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

import com.boothen.jsonedit.core.JsonEditorPlugin;
import com.boothen.jsonedit.core.model.jsonnode.JsonNode;
import com.boothen.jsonedit.core.model.node.Node;
import com.boothen.jsonedit.core.outline.JsonContentOutlinePage;

/**
 * JsonTextEditor is the TextEditor instance used by the plugin.
 *
 * @author Matt Garner
 *
 */
public class JsonTextEditor extends TextEditor {

	private JsonSourceViewerConfiguration viewerConfiguration;

	private final static char[] PAIRS= { '{', '}', '[', ']' };

	private DefaultCharacterPairMatcher pairsMatcher = new DefaultCharacterPairMatcher(PAIRS);


	/** The outline page */
	private JsonContentOutlinePage fOutlinePage;
	private ProjectionAnnotationModel annotationModel;
	private ProjectionSupport projectionSupport;
	private ProjectionAnnotation[] oldAnnotations;
	private boolean[] annotationCollapsedState;
	private int nodePositionOffset = 0;
	private int nodePosition = 0;
	private List<JsonNode> jsonNodes;
	private List<Node> nodes;

	public JsonTextEditor() {
		super();

	}

	@Override
	protected void configureSourceViewerDecorationSupport(SourceViewerDecorationSupport support) {
		support.setCharacterPairMatcher(pairsMatcher);

		support.setMatchingCharacterPainterPreferenceKeys(JsonEditorPlugin.EDITOR_MATCHING_BRACKETS, JsonEditorPlugin.EDITOR_MATCHING_BRACKETS_COLOR);
		super.configureSourceViewerDecorationSupport(support);
	}

	protected void initializeEditor() {
		super.initializeEditor();
		setEditorContextMenuId("#JsonTextEditorContext"); //$NON-NLS-1$
		setRulerContextMenuId("#JsonTextRulerContext"); //$NON-NLS-1$
		viewerConfiguration = new JsonSourceViewerConfiguration(this);
		setSourceViewerConfiguration(viewerConfiguration);
	}

	public void dispose() {
		if (fOutlinePage != null)
			fOutlinePage.setInput(null);

		if (pairsMatcher != null) {
			pairsMatcher.dispose();
			pairsMatcher = null;
		}

		super.dispose();
	}

	public void doRevertToSaved() {
		super.doRevertToSaved();
		if (fOutlinePage != null)
			fOutlinePage.update();
	}

	public void doSave(IProgressMonitor monitor) {
		super.doSave(monitor);
		if (fOutlinePage != null)
			fOutlinePage.update();
	}

	/** The <code>JavaEditor</code> implementation of this
	 * <code>AbstractTextEditor</code> method performs any extra
	 * save as behavior required by the java editor.
	 */
	public void doSaveAs() {
		super.doSaveAs();
		if (fOutlinePage != null)
			fOutlinePage.update();
	}

	/** The <code>JavaEditor</code> implementation of this
	 * <code>AbstractTextEditor</code> method performs sets the
	 * input of the outline page after AbstractTextEditor has set input.
	 *
	 * @param input the editor input
	 * @throws CoreException in case the input can not be set
	 */
	public void doSetInput(IEditorInput input) throws CoreException {
		super.doSetInput(input);
		if (fOutlinePage != null)
			fOutlinePage.setInput(input);
	}

	/** The <code>JavaEditor</code> implementation of this
	 * <code>AbstractTextEditor</code> method performs gets
	 * the java content outline page if request is for a an
	 * outline page.
	 *
	 * @param required the required type
	 * @return an adapter for the required type or <code>null</code>
	 */
	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class required) {
		if (IContentOutlinePage.class.equals(required)) {
			if (fOutlinePage == null) {
				fOutlinePage= new JsonContentOutlinePage(getDocumentProvider(), this);
				if (getEditorInput() != null)
					fOutlinePage.setInput(getEditorInput());
			}
			return fOutlinePage;
		}

		return super.getAdapter(required);
	}

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		ProjectionViewer viewer =(ProjectionViewer)getSourceViewer();

		projectionSupport = new ProjectionSupport(viewer,getAnnotationAccess(),getSharedColors());
		projectionSupport.install();

		//turn projection mode on
		viewer.doOperation(ProjectionViewer.TOGGLE);

		annotationModel = viewer.getProjectionAnnotationModel();

		SourceViewerDecorationSupport support = getSourceViewerDecorationSupport(viewer);
		support.install(JsonEditorPlugin.getJsonPreferenceStore());
	}

	@Override
	protected ISourceViewer createSourceViewer(Composite parent,
			IVerticalRuler ruler, int styles) {

		ISourceViewer viewer = new ProjectionViewer(parent, ruler, getOverviewRuler(), isOverviewRulerVisible(), styles);

		// ensure decoration support has been created and configured.
		getSourceViewerDecorationSupport(viewer);
		return viewer;
	}

	public void updateFoldingStructure(List<Position> positions)
	{
		ProjectionAnnotation[] annotations = new ProjectionAnnotation[positions.size()];

		//this will hold the new annotations along
		//with their corresponding positions
		HashMap<ProjectionAnnotation, Position> newAnnotations = new HashMap<ProjectionAnnotation, Position>();

		for(int i =0;i<positions.size();i++)
		{
			ProjectionAnnotation annotation = new ProjectionAnnotation();
			newAnnotations.put(annotation,positions.get(i));
			annotations[i] = annotation;
			if (annotationCollapsedState != null && annotationCollapsedState.length > i && annotationCollapsedState[i]) {
				annotation.markCollapsed();
			}
		}

		annotationModel.modifyAnnotations(oldAnnotations,newAnnotations,null);

		oldAnnotations = annotations;
	}

	public JsonContentOutlinePage getFOutlinePage() {
		return fOutlinePage;
	}

	public void updateContentOutlinePage(List<JsonNode> jsonNodes, List<Node> nodes) {
		this.jsonNodes = jsonNodes;
		this.nodes = nodes;
		if (fOutlinePage != null) {
			fOutlinePage.setJsonNodes(jsonNodes);
		}

		restoreTextLocation();
	}

	public void storeOutlineState() {
		if (oldAnnotations != null) {
			annotationCollapsedState = new boolean[oldAnnotations.length];
			for (int i = 0; i < oldAnnotations.length; i++) {
				annotationCollapsedState[i] = oldAnnotations[i].isCollapsed();
			}
		}
	}

	public void storeTextLocation() {
		ITextSelection iTextSelection = (ITextSelection) this.getSite().getSelectionProvider().getSelection();
		int textLocation = iTextSelection.getOffset();
		if (nodes != null) {
			for (int i = 0; i < nodes.size(); i++) {
				Node node = nodes.get(i);
				if (node.getPosition().includes(textLocation)) {
					nodePosition = i;
					nodePositionOffset = textLocation - node.getPosition().getOffset();
					break;
				}
			}
		}
	}

	public void restoreTextLocation() {
		ITextOperationTarget target = (ITextOperationTarget) this.getAdapter(ITextOperationTarget.class);
		if (!(target instanceof ITextViewer)) {
			return ;
		}
		ITextViewer textViewer = (ITextViewer) target;
		if (nodes != null) {
			Node node = nodes.get(nodePosition);
			if (node != null) {
				int textLocation = node.getPosition().getOffset() + nodePositionOffset;
				textViewer.getTextWidget().setSelection(textLocation);
			}
		}
	}
}
