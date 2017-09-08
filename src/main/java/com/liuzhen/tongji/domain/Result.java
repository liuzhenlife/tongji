package com.liuzhen.tongji.domain;

/**
 * Created by liuzhen on 2017/9/8.
 */
public class Result {
    private long site_uv;
    private long page_pv;
    private long site_pv;

    public long getSite_uv() {
        return site_uv;
    }

    public void setSite_uv(long site_uv) {
        this.site_uv = site_uv;
    }

    public long getPage_pv() {
        return page_pv;
    }

    public void setPage_pv(long page_pv) {
        this.page_pv = page_pv;
    }

    public long getSite_pv() {
        return site_pv;
    }

    public void setSite_pv(long site_pv) {
        this.site_pv = site_pv;
    }
}
