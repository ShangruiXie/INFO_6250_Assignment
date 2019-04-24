package com.blog.exception;

public class CommentException extends Exception {
	public CommentException(String message)
	{
		super("CommentException-"+message);
	}
	
	public CommentException(String message, Throwable cause)
	{
		super("CommentException-"+message,cause);
	}
}
