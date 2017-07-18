package com.opslab.workflow.util;

import org.junit.Test;

import com.opslab.workflow.framework.entity.view.UiTree;

public class JacksonUtilTest {

	@Test
	public void testToJSON() {
		UiTree tree = new UiTree("treeId","treeName","treeParentId");
		System.out.println(JacksonUtil.toJSON(tree));
	}

}
