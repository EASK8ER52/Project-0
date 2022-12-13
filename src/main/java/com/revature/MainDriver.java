package com.revature;


import java.util.*;

import com.revature.controller.RequestMapping;

import io.javalin.Javalin;

public class MainDriver
{
	public static List<String> names = new ArrayList<>();

	public static void main(String[] args)
	{
		/*Javalin app = Javalin.create(confg ->
		{
			confg.plugins.enableDevLogging();
		});
		RequestMapping.setupEndpoints(app);
		app.start(7000);*/
		names.add("Clark");
		names.add("Bruce");
		names.add("Oliver");
		Javalin app = Javalin.create();

		app.get("/hello", ctx -> ctx.result("Hello Heroes!"));

		app.post("/add", ctx ->
		{
			String newName = ctx.body();
			names.add(newName);
			ctx.result("Congrats you've added a new name to the database");
			ctx.status(201);
		});

		app.start();
	}
}
