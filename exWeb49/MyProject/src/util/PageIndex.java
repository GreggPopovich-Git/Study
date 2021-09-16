package util;

import java.net.URLEncoder;

public class PageIndex {
	public static String pageList(int page,int totpage,String url,String addtag) {
		int idx_pre, idx_start;
		
		String s_pre = "";    // Prev 저장 변수
		String s_idx = "";    // 번호 저장 변수
		String s_next = "";   // Next 저장 변수

		idx_start = ((page-1) / 3) * 3 + 1 ;  // 시작 페이지 계산
		idx_pre = ((page-1) / 3);              // Priview 페이지 계산

	  	// Prev 표시 부분
	  	if(idx_pre > 0) {
	  		s_pre = "<li><a href='"+url+"?page="+(idx_pre*3)+addtag+"'>이전</a></li>";
	  	}

	  	// 번호 표시부분	
	  	for(int i=0;i<3;i++,idx_start++) {
	  		if(idx_start>totpage) break;
	  		s_idx = s_idx + "<li><a href='" + url + "?page=" + idx_start;
  			s_idx = s_idx + addtag + "'> " + idx_start + " </a></li>";
	  	}
		// Next 표시부분
	  	if(idx_start <= totpage ) {
	  		s_next = "<li><a href='"+url+"?page="+idx_start+addtag+"'>"
	  				+ "다음</a></li>";
	  	}

	  	String outHtml = "<ul>" + s_pre + s_idx + s_next + "</ul>";  // Html 문 조합
	  	return outHtml;
	}

	public static String pageListHan(int page,int totpage,String url,String query, String key) {
		int idx_pre, idx_start;
		  	
		String s_pre = "";    // Prev 저장 변수
		String s_idx = "";    // 번호 저장 변수
		String s_next = "";   // Next 저장 변수

		idx_start = ((page-1) / 3) * 3 + 1 ;  // 시작 페이지 계산
		idx_pre = ((page-1) / 3);              // Priview 페이지 계산

	  	// Prev 표시 부분
	  	if(idx_pre > 0) {
	  		s_pre = "<li><a href='"+url+"?page="+(idx_pre*3)+"&search="+query+"&key="+ URLEncoder.encode(key)+"'>"
	  				+ "이전</a></li>";
	  	}

	  	// 번호 표시부분	
	  	for(int i=0;i<totpage;i++,idx_start++) {
	  		if(idx_start>totpage) break;
  			s_idx = s_idx + "<li><a href='" + url + "?page=" + idx_start;
  			s_idx = s_idx + "&search="+query+"&key=" + URLEncoder.encode(key) + "'> " + idx_start + " </a></li>";
	  	}
		// Next 표시부분
	  	if(idx_start <= totpage ) {
	  		s_next = "<li><a href='"+url+"?page="+idx_start+ "&search="+query+"&key="+ URLEncoder.encode(key)+"'>"
	  				+ "다음</a></li>";
	  	}

	  	String outHtml = "<ul>" + s_pre + s_idx + s_next + "</ul>";  // Html 문 조합
	  	return outHtml;
	}
	// type
	public static String pageList(int page,int totpage,String url,String addtag,String type) {
		int idx_pre, idx_start;
		
		String s_pre = "";    // Prev 저장 변수
		String s_idx = "";    // 번호 저장 변수
		String s_next = "";   // Next 저장 변수

		idx_start = ((page-1) / 3) * 3 + 1 ;  // 시작 페이지 계산
		idx_pre = ((page-1) / 3);              // Priview 페이지 계산

	  	// Prev 표시 부분
	  	if(idx_pre > 0) {
	  		s_pre = "<li><a href='"+url+"?page="+(idx_pre*3)+addtag+"&type="+type+"'>이전</a></li>";
	  	}

	  	// 번호 표시부분	
	  	for(int i=0;i<3;i++,idx_start++) {
	  		if(idx_start>totpage) break;
	  		s_idx = s_idx + "<li><a href='" + url + "?page=" + idx_start+"&type="+type;
  			s_idx = s_idx + addtag + "'> " + idx_start + " </a></li>";
	  	}
		// Next 표시부분
	  	if(idx_start <= totpage ) {
	  		s_next = "<li><a href='"+url+"?page="+idx_start+addtag+"&type="+type+"'>"
	  				+ "다음</a></li>";
	  	}

	  	String outHtml = "<ul>" + s_pre + s_idx + s_next + "</ul>";  // Html 문 조합
	  	return outHtml;
	}

	public static String pageListHan(int page,int totpage,String url,String query,String key,String type) {
		int idx_pre, idx_start;
		  	
		String s_pre = "";    // Prev 저장 변수
		String s_idx = "";    // 번호 저장 변수
		String s_next = "";   // Next 저장 변수

		idx_start = ((page-1) / 3) * 3 + 1 ;  // 시작 페이지 계산
		idx_pre = ((page-1) / 3);              // Priview 페이지 계산

	  	// Prev 표시 부분
	  	if(idx_pre > 0) {
	  		s_pre = "<li><a href='"+url+"?page="+(idx_pre*3)+"&search="+query+"&key="+ URLEncoder.encode(key)+"&type="+type+"'>"
	  				+ "이전</a></li>";
	  	}

	  	// 번호 표시부분	
	  	for(int i=0;i<totpage;i++,idx_start++) {
	  		if(idx_start>totpage) break;
  			s_idx = s_idx + "<li><a href='" + url + "?page=" + idx_start+"&type="+type;
  			s_idx = s_idx + "&search="+query+"&key=" + URLEncoder.encode(key) + "'> " + idx_start + " </a></li>";
	  	}
		// Next 표시부분
	  	if(idx_start <= totpage ) {
	  		s_next = "<li><a href='"+url+"?page="+idx_start+ "&search="+query+"&key="+ URLEncoder.encode(key)+"&type="+type+"'>"
	  				+ "다음</a></li>";
	  	}

	  	String outHtml = "<ul>" + s_pre + s_idx + s_next + "</ul>";  // Html 문 조합
	  	return outHtml;
	}
}
