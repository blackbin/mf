package com.jzhu.study.datalayer.entities;

/**
 * Created by zhujian on 2017/3/16.
 *  "_id": "58c9f47f421aa95810795c73",
 "createdAt": "2017-03-16T10:12:15.342Z",
 "desc": "3-16",
 "publishedAt": "2017-03-16T11:37:02.85Z",
 "source": "chrome",
 "type": "\u798f\u5229",
 "url": "http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-16-17333221_108837802984751_2789267558635667456_n.jpg",
 "used": true,
 "who": "dmj"
 */

public class GankFLEntities {

    private String _id ;
    private String createAt ;
    private String desc;
    private String publishedAt;
    private String source;
    private String type;
    private String url;
    private boolean use;
    private String who;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUse() {
        return use;
    }

    public void setUse(boolean use) {
        this.use = use;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }
}
