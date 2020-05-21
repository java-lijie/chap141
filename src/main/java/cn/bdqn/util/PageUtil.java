package cn.bdqn.util;

public class PageUtil {

    private int totalRecordCount;//总数据
    private int pageSize=10;//每页显示数量
    private int currentPageNo=0;//当前页数
    private int totalPageCount;//总页数

    public int getTotalRecordCount() {
        return totalRecordCount;
    }

    public void setTotalRecordCount(int totalRecordCount) {
        this.totalRecordCount = totalRecordCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(int currentPageNo) {
        this.currentPageNo = currentPageNo;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount() {
        if(totalRecordCount%pageSize==0){
            this.totalPageCount =totalRecordCount/pageSize;
        }else {
            this.totalPageCount =(totalRecordCount/pageSize)+1;
        }

    }
}
