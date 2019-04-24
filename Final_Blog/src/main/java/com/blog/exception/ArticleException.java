package com.blog.exception;

public class ArticleException extends Exception {
	public ArticleException(String message)
	{
		super("ArticleException-"+message);
	}
	
	public ArticleException(String message, Throwable cause)
	{
		super("ArticleException-"+message,cause);
	}
}
