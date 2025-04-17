Process
------------
1. I first generated my usual boilerplate starter code for the app, I have a tool i use to do this for projects of varying sizes, the boilerplate includes dependencies, and basic app structure with the MVVM architecture.
2. Next, since I am not a designer, I turned to my usual LLM, Gemini to help me with this, unfortunately it gave me many ideas on the app structure but it couldn't generate an image
3. Then I tried ChatGPT this worked spectacularly. Generating two images which are included in the /images folder.
4. Then I asked for making safe api calls and an extension function that would handle all possible exceptions from this network call and then output a concise readable user message.
5. Next, from the suggestions made by ChatGPT, I generated the corresponding Compose UI code for the app based on the suggested UI mockups.
6. Then generated the corresponding Viewmodel code that handles the business logic of the app.
7. I added these pieces of code to the app and then made some minor adjustments to clean up and optimize the code.
8. I also made some UI changes to make the app more user friendly and conform to the Material design guidelines.
9. Lastly, I asked Gemini to help me create Unit test case scenarios for the repository layer, I could have added the code myself or used a different tool to complete this but i didn't want to spend more than the recommended time.


Reasoning 
------------
When Using AI I like generate functions and classes piece meal, I prefer this to large scale code generation tools so i don't have sections of my project where i don't recognise the code, this greatly improves the readability of the code and
my ability to maintain it in the long run. I also helps me control the standards and structure of my code. AI is usually style agnostic and can also use different "styles" from function to function and section to section.
I mostly use AI tools to carry out non creative repetitive work, tasks i would usually have had to google everytime or copy and paste from an older project for example writing an APIInterface for Retrofit. It also helps me to
carry out actions without leaving my IDE environment, especially since Copilot and Gemini easily integrate with Android Studio. It helps me handle edge cases, error cases and edge cases that i would not have considered worth the hassle if i was 
writing them all out myself. Using the AI tools as a UI/UX designer has been a god send, using AI in general as a coworker has been amazing, for example when i am making a tiny app that might require a UI mockup and a small backend network 
service, these are things i usually cannot do (i do have some spring boot with kotlin experience) easily. AI greatly solves this problem for me.

I chose a basic MVVM app structure because i felt the app didn't need any special modifications, it just makes a simple network call and shows that data. I used Koin because its very lightweight to setup and easy to use. I chose Compose UI because 
its becoming the conventional UI framework for Android and it would properly handle the state changes, and it would save me the trouble of making a Recyclerview with an adapter, onItemClickListeners and other accompanying boilerplate code

I did all these in around 45 minutes, the whole process was incredibly simplified with the AI tools.