package com.boothen.jsonedit.core.model;


import org.eclipse.jface.text.IDocument;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.boothen.jsonedit.core.model.jsonnode.JsonNode;
import com.boothen.jsonedit.core.model.node.Node;
import com.boothen.jsonedit.core.util.FileToDocUtility;

public class JsonReconcilingStrategyTest {

	public static int[] failingTests = new int[] {5,6,7, 37, 38, 39};
	@Before
	public void onSetup() {

	}


	public void tearDown() {

	}

	@Test
	public void testFile1() {

		IDocument doc = FileToDocUtility.getDocument("test1.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(75, jtop.nodes.size());

		Assert.assertEquals(15, jtop.jsonNodes.size());
	}

	@Test
	public void testFile2() {

		IDocument doc = FileToDocUtility.getDocument("test2.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(315, jtop.nodes.size());

		Assert.assertEquals(48, jtop.jsonNodes.size());
	}

	@Test
	public void testFile3() {

		IDocument doc = FileToDocUtility.getDocument("test3.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(386, jtop.nodes.size());

		Assert.assertEquals(63, jtop.jsonNodes.size());
	}

	@Test
	public void testFile4() {

		IDocument doc = FileToDocUtility.getDocument("test4.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(97, jtop.nodes.size());

		Assert.assertEquals(30, jtop.jsonNodes.size());
	}

	@Test
	@Ignore
	public void testFile5() {

		IDocument doc = FileToDocUtility.getDocument("test5.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(4, jtop.nodes.size());

		Assert.assertEquals(3, jtop.jsonNodes.size());
	}

	@Test
	@Ignore
	public void testFile6() {

		IDocument doc = FileToDocUtility.getDocument("test6.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(7, jtop.nodes.size());
		Assert.assertEquals(3, jtop.jsonNodes.size());
	}

	@Test
	@Ignore
	public void testFile7() {

		IDocument doc = FileToDocUtility.getDocument("test7.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(10, jtop.nodes.size());
		Assert.assertEquals(4, jtop.jsonNodes.size());
	}

	@Test
	public void testFile8() {

		IDocument doc = FileToDocUtility.getDocument("test8.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(7, jtop.nodes.size());
		Assert.assertEquals(3, jtop.jsonNodes.size());
	}

	@Test
	public void testFile9() {

		IDocument doc = FileToDocUtility.getDocument("test9.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(21, jtop.nodes.size());
		Assert.assertEquals(8, jtop.jsonNodes.size());
	}

	@Test
	public void testFile12() {

		IDocument doc = FileToDocUtility.getDocument("test12.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(27, jtop.nodes.size());
		Assert.assertEquals(8, jtop.jsonNodes.size());
	}

	@Test
	public void testFile13() {

		IDocument doc = FileToDocUtility.getDocument("test13.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(9, jtop.nodes.size());
		Assert.assertEquals(3, jtop.jsonNodes.size());
	}

	@Test
	public void testFile14() {

		IDocument doc = FileToDocUtility.getDocument("test14.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(17, jtop.nodes.size());
		Assert.assertEquals(4, jtop.jsonNodes.size());
	}

	@Test
	public void testFile15() {

		IDocument doc = FileToDocUtility.getDocument("test15.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(17, jtop.nodes.size());
		Assert.assertEquals(4, jtop.jsonNodes.size());
	}

	@Test
	public void testFile16() {

		IDocument doc = FileToDocUtility.getDocument("test16.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(9, jtop.nodes.size());
		Assert.assertEquals(3, jtop.jsonNodes.size());
	}

	@Test
	public void testFile17() {

		IDocument doc = FileToDocUtility.getDocument("test17.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(10, jtop.nodes.size());
		Assert.assertEquals(4, jtop.jsonNodes.size());
	}

	@Test
	public void testFile18() {

		IDocument doc = FileToDocUtility.getDocument("test18.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(11, jtop.nodes.size());
		Assert.assertEquals(4, jtop.jsonNodes.size());
	}

	@Test
	public void testFile19() {

		IDocument doc = FileToDocUtility.getDocument("test19.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();
		System.out.println("");
		for (Node node : jtop.nodes) {
			System.out.println(node);
		}
		System.out.println("");
		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(8, jtop.nodes.size());
		Assert.assertEquals(4, jtop.jsonNodes.size());
	}

	@Test
	public void testFile20() {

		IDocument doc = FileToDocUtility.getDocument("test20.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(12, jtop.nodes.size());
		Assert.assertEquals(4, jtop.jsonNodes.size());
	}

	@Test
	public void testFile21() {

		IDocument doc = FileToDocUtility.getDocument("test21.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(16, jtop.nodes.size());
		Assert.assertEquals(5, jtop.jsonNodes.size());
	}

	@Test
	public void testFile22() {

		IDocument doc = FileToDocUtility.getDocument("test22.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(19, jtop.nodes.size());
		Assert.assertEquals(6, jtop.jsonNodes.size());
	}

		@Test
	public void testFile23() {

		IDocument doc = FileToDocUtility.getDocument("test23.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(27, jtop.nodes.size());
		Assert.assertEquals(7, jtop.jsonNodes.size());

    }

	@Test
	public void testFile24() {

		IDocument doc = FileToDocUtility.getDocument("test24.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(25, jtop.nodes.size());
		Assert.assertEquals(5, jtop.jsonNodes.size());
	}

	@Test
	public void testFile25() {

		IDocument doc = FileToDocUtility.getDocument("test25.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(9, jtop.nodes.size());
		Assert.assertEquals(3, jtop.jsonNodes.size());
	}

	@Test
	public void testFile26() {

		IDocument doc = FileToDocUtility.getDocument("test26.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(31, jtop.nodes.size());
		Assert.assertEquals(14, jtop.jsonNodes.size());
	}

	@Test
	public void testFile27() {

		IDocument doc = FileToDocUtility.getDocument("test27.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(17, jtop.nodes.size());
		Assert.assertEquals(7, jtop.jsonNodes.size());
	}

	@Test
	public void testFile28() {

		IDocument doc = FileToDocUtility.getDocument("test28.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(29, jtop.nodes.size());
		Assert.assertEquals(8, jtop.jsonNodes.size());
	}

	@Test
	public void testFile29() {

		IDocument doc = FileToDocUtility.getDocument("test29.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(17, jtop.nodes.size());
		Assert.assertEquals(7, jtop.jsonNodes.size());
	}

	@Test
	public void testFile30() {

		IDocument doc = FileToDocUtility.getDocument("test30.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(7, jtop.nodes.size());
		Assert.assertEquals(3, jtop.jsonNodes.size());
	}

	@Test
	public void testFile31() {

		IDocument doc = FileToDocUtility.getDocument("test31.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(27, jtop.nodes.size());
		Assert.assertEquals(8, jtop.jsonNodes.size());
	}

	@Test
	public void testFile32() {

		IDocument doc = FileToDocUtility.getDocument("test32.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(27, jtop.nodes.size());
		Assert.assertEquals(8, jtop.jsonNodes.size());
	}

	@Test
	public void testFile33() {

		IDocument doc = FileToDocUtility.getDocument("test33.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		System.out.println("");
		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		System.out.println("");
		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(9, jtop.nodes.size());
		Assert.assertEquals(3, jtop.jsonNodes.size());
	}

	@Test
	public void testFile34() {

		IDocument doc = FileToDocUtility.getDocument("test34.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		System.out.println("");
		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		System.out.println("");
		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(9, jtop.nodes.size());
		Assert.assertEquals(3, jtop.jsonNodes.size());
	}

	@Test
	public void testFile35() {

		IDocument doc = FileToDocUtility.getDocument("test35.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		System.out.println("");
		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		System.out.println("");
		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(9, jtop.nodes.size());
		Assert.assertEquals(4, jtop.jsonNodes.size());
	}

	@Test
	public void testFile36() {

		IDocument doc = FileToDocUtility.getDocument("test36.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		System.out.println("");
		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		System.out.println("");
		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(2, jtop.nodes.size());
		Assert.assertEquals(2, jtop.jsonNodes.size());
	}

	@Test
	@Ignore
	public void testFile37() {

		IDocument doc = FileToDocUtility.getDocument("test37.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		System.out.println("");
		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		System.out.println("");
		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(2, jtop.nodes.size());
		Assert.assertEquals(2, jtop.jsonNodes.size());
	}

	@Test
	@Ignore
	public void testFile38() {

		IDocument doc = FileToDocUtility.getDocument("test38.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		System.out.println("");
		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		System.out.println("");
		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(2, jtop.nodes.size());
		Assert.assertEquals(2, jtop.jsonNodes.size());
	}

	@Test
	@Ignore
	public void testFile39() {

		IDocument doc = FileToDocUtility.getDocument("test39.json");

		JsonReconcilingStrategy jtop = new JsonReconcilingStrategy();
		jtop.setDocument(doc);

		jtop.initialReconcile();

		System.out.println("");
		for (Node node : jtop.nodes) {
			System.out.println(node);
		}

		System.out.println("");
		for (JsonNode node : jtop.jsonNodes) {
			System.out.println(node);
		}

		Assert.assertEquals(5, jtop.nodes.size());
		Assert.assertEquals(3, jtop.jsonNodes.size());
	}
}