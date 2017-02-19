package com.wt.tools;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.wt.improperChar.ImproperWord;
import com.wt.improperChar.OperWords;


/**
 * Servlet Filter implementation class WordsFilter
 */
@WebFilter("/WordsFilter")
public class WordsFilter implements Filter {

	private String encoding;
	//private String[] words;
	private List<ImproperWord> list;
    
    public WordsFilter() {
        // TODO Auto-generated constructor stub
    }
    /**
     * 具体过滤方法，并将非法字符替换成***
     */
    public String filter(String param) {
//		if(words!=null&&words.length>0){
//			for (int i = 0; i < words.length; i++) {
//				if(param.indexOf(words[i])!=-1){
//					param = param.replaceAll(words[i], "***");
//				}
//			}
//		}
		
    	if(param!=null){
    	
		if(list!=null&&list.size()>0){
			for (int i = 0; i < list.size(); i++) {
				if(param.indexOf(list.get(i).getWords())!=-1){
					param = param.replaceAll(list.get(i).getWords(), "***");
				}
			}
		}
	
    	}
		
		return param;
	}
    /**
     * 重写servletrequest的getparameter()和getparametervalues()
     */
    
    class Request extends HttpServletRequestWrapper{

		public Request(HttpServletRequest request) {
			super(request);
		}

		@Override
		public String getParameter(String name) {
			// TODO Auto-generated method stub
			if(name!=null){
			return filter(super.getParameter(name));
			}else{
				return super.getParameter(name);
			}
		}

		@Override
		public String[] getParameterValues(String name) {
			// TODO Auto-generated method stub
			if(name!=null){
			String[] values = super.getParameterValues(name);
			for (int i = 0; i < values.length; i++) {
				values[i] = filter(values[i]);
			}
			return values;
			}else{
				return super.getParameterValues(name);
			}
		}
    	
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		this.encoding=null;
		this.list=null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(encoding!=null){
			request.setCharacterEncoding(encoding);
			request = new Request((HttpServletRequest)request);
			response.setContentType("text/html; charset = "+encoding);
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

		encoding = fConfig.getInitParameter("encoding");
		list = OperWords.selectWord();
		//words = new String[]{"卧槽","我草","我cao","操你妈","傻逼","sb","习近平"};
	}

}
