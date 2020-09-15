package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;

public interface Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ;
}
