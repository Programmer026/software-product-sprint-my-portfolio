// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/data")
public final class DataServlet extends HttpServlet {

    private ArrayList<String> quotes;

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String json = convertToJson(quotes); 

    response.setContentType("application/json;");
    response.getWriter().println(json);
  }

    @Override
  public void init(){
    quotes = new ArrayList<>();
    quotes.add("I have not failed. "
        + "I've just found 10,000 ways that doesn't work. - Thomas A. Edison");
    quotes.add("Success is not final, Failure is not fatal: " 
        + "it is the courage to continue that counts. - Winston S. Churchill");
    quotes.add("There is only one thing that makes a dream impossible to acheive: "
        + "The fear of failure. - Paulo Coelho");
    quotes.add("Failure is the condiment that gives success its flavor. - Truman Capote");
    quotes.add("Have no fear of perfection - you'll never reach it. - Salvador Dali");
  }

  private String convertToJson(ArrayList<String> quotes) {
    String json = "{";
    json += "\"Quote1\": ";
    json += "\"" + quotes.get(0) + "\"";
    json += ", ";
    json += "\"Quote2\": ";
    json += "\"" + quotes.get(1) + "\"";
    json += ", ";
    json += "\"Quote3\": ";
    json += "\"" + quotes.get(2) + "\"";
    json += ", ";
    json += "\"Quote4\": ";
    json += "\"" + quotes.get(3) + "\"";
    json += "}";
    return json;
  }

}
