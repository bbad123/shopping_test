package kr.co.sptek.member.common;

import kr.co.sptek.member.info.ConditionInfo;

public class PageHtmlUtil {
	
		public PageHtmlUtil(){
			
		}
		
	
	    // A method for Creating page html code
		//public String getPageHtml(int currentPage, double totalNum, int showArticleLimit, int showPageLimit, String urlPath) {
		public String getPageHtml(ConditionInfo condition, double totalNum) {
			StringBuffer pageHtml = new StringBuffer();
			int startPage = 0;
			int lastPage = 0;
			
			// expression page variables
			startPage = ((condition.getCurrentPage() - 1) / condition.getShowPageLimit()) * condition.getShowPageLimit() + 1;
			//startPage = condition.getCurrentPage();
			lastPage = startPage + condition.getShowPageLimit() - 1;
			
			if(lastPage > totalNum / condition.getShowArticleLimit()) {
				if((totalNum % condition.getShowArticleLimit()) == 0)
					lastPage = (int)(totalNum / condition.getShowArticleLimit());
				else 
					lastPage = (int)(totalNum / condition.getShowArticleLimit()) + 1;
			}
			
			System.out.println("startPage = " + startPage);
			System.out.println("lastPage = " + lastPage);
			System.out.println("totalNum = " + totalNum);
			System.out.println("cals = " + totalNum / condition.getShowArticleLimit());
			
			// create page html code						
			if(startPage == 1){
				pageHtml.append("<span><이전>&nbsp;&nbsp;");
			} else {
				pageHtml.append("<span><a href='javascript:sendPage(" + (startPage-1) + ")'><이전></a>&nbsp;&nbsp;");
			}
			
			for(int i = startPage ; i <= lastPage ; i++) {
				if(i == condition.getCurrentPage()){
					pageHtml.append(".&nbsp;<strong>");
					pageHtml.append("<a href='javascript:sendPage(" + i +")' class=\"page\">" + i + "</a>");
					pageHtml.append("&nbsp;</strong>");
				} else {
					pageHtml.append(".&nbsp;<a href='javascript:sendPage(" + i +")' class=\"page\">" + i + "</a>&nbsp;");
				}
				
			}
			
			if(lastPage < totalNum / condition.getShowArticleLimit()){
				pageHtml.append(".&nbsp;&nbsp;<a href='javascript:sendPage(" + (lastPage+1) + ")'><다음></a></span>");
			}else {
				//if(condition.getCurrentPage() == lastPage){
					pageHtml.append(". <다음></span>");
				//} else {
				//	pageHtml.append(".&nbsp;&nbsp;<a href='javascript:sendPage(" + (condition.getCurrentPage()+1) + ")'><다음></a></span>");
				//}
			}
			
			//		
			return pageHtml.toString();
		}

}
