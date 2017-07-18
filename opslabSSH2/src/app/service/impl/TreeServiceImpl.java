package app.service.impl;

import org.springframework.stereotype.Service;

import app.entries.Tree;
import app.service.TreeService;

@Service("treeService")
public class TreeServiceImpl extends SupportServiceImpl<Tree> implements TreeService {

}
