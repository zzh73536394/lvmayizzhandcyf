package com.jk.bean;

import java.util.List;

public class Tree {

    private Integer id;

    private String text;

    private String href;

    private Integer pid;

    private List<Tree> nodes;//放子节点数据

    private Boolean selectable;//节点是否可以点击，打开选项卡

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public List<Tree> getNodes() {
        return nodes;
    }

    public void setNodes(List<Tree> nodes) {
        this.nodes = nodes;
    }

    public Boolean getSelectable() {
        return selectable;
    }

    public void setSelectable(Boolean selectable) {
        this.selectable = selectable;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", href='" + href + '\'' +
                ", pid=" + pid +
                ", nodes=" + nodes +
                ", selectable=" + selectable +
                '}';
    }
}
