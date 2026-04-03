package com.dryRUn;

import org.hamcrest.core.Is;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import api.request.models.PostModel;
import api.services.PostsService;
import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;

public class APIDryRun {
	
	@Test(description = "Fetch all the post", enabled = false)
	public void getAllPosts() {
		
		PostsService posts= new PostsService();
		Response resp= posts.getAllPosts();
		resp.prettyPrint();
	}
	
	
	@Test(description = "Fetch all the post for specific post id",enabled = false)
	public void getSpecificPosts() {
		
		PostsService posts= new PostsService();
		Response resp= posts.getPosts(1);
		resp.prettyPrint();
	}
	
	
	@Test(description = "Fetch all the post for specific post id",enabled = false)
	public void createPost() {
		
		PostsService posts= new PostsService();
		PostModel model= new PostModel.Builder().userId(1).id(104).title("Random title").body("This is the posts body content").build();
		Response resp= posts.createPost(model);
		
		resp.prettyPrint();
	}
	
	
	@Test(description = "Fluent Assertions")
	public void FluentAssertions() {

		PostsService posts= new PostsService();
		RequestSpecification reqst= posts.getBaseRequest();
		reqst.when().get()
		.then()
		.log().all()
		.assertThat()
		.statusCode(200)
		.body("[0].userId", Is.is(1))
		.body("[0].userId", equalTo(1))
		.body("[0].title", containsString("sunt aut facere repellat provident occaecati exc"))
		.time(lessThan(2000L));
	}

}
