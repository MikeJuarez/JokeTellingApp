package com.example;

import java.util.ArrayList;
import java.util.Random;

public class Joker {
    public String getJoke() {
        ArrayList<String> jokeList = new ArrayList<>();
        jokeList.add("What do you call a fake noodle??<p> <b>An Im-pasta!</b>");
        jokeList.add("Why can't your nose be 12 inches long??<p> <b>An Im-pasta!</b>");
        jokeList.add("What do you call a mile of cats??<p> <b> meowtain!</b>");
        jokeList.add("Why did the yogurt go to the museum?<p> <b>Because it was cultured!</b>");
        jokeList.add("What's a pepper that won't leave you alone?<p> <b>Jalapeno business!</b>");
        jokeList.add("How many tickles does it take to make an octopus laugh?<p> <b>Ten-tickles!</b>");
        jokeList.add("What kind of room can't you enter?<p> <b>A mushroom!</b>");
        jokeList.add("What do you get when you decorate for Christmas?<p> <b>Tinselitus!</b>");
        jokeList.add("What do you call an alligator in a vest?<p> <b>An investigator!</b>");
        jokeList.add("Why did the fish get bad grades?<p> <b>Because it was below sea level!</b>");
        jokeList.add("How do you put an alien baby to sleep?<p> <b>You rocket!</b>");
        jokeList.add("Where did Noah keep his bees?<p> <b>In his ark hives!</b>");
        jokeList.add("What do you call a snobbish criminal going down the stairs?<p> <b>A condescending con descending!</b>");
        jokeList.add("Why did the mermaid wear seashells?<p> <b>Because the B-shells were too small and the D-shells were too big!</b>");
        jokeList.add("Why did the bicycle fall over?<p> <b>Because it was two tired!</b>");
        jokeList.add("How do you organize a space party?<p> <b>You planet!</b>");
        jokeList.add("Where did the cow take his date?<p> <b>The MOOvies!</b>");
        jokeList.add("Why do seagulls live by the sea?<p> <b>Because if they lived by the bay, they'd be called bagels!</b>");
        jokeList.add("What do you call a group of unorganized cats?<p> <b>A cat-astrophe!</b>");
        jokeList.add("Why does Snoop Dogg use an umbrella?<p> <b>For dizzle!</b>");
        jokeList.add("Why did the melons get married?<p> <b>Because they cantaloupe!</b>");
        jokeList.add("What did one eye say to the other eye?<p> <b>Between you and me, something smells!</b>");
        jokeList.add("Have you heard the joke about pizza?<p> <b>Never mind, it's too cheesy!</b>");

        Random random = new Random();
        int n = random.nextInt(jokeList.size());

        return jokeList.get(n);
    }
    //public String getJoke() {  return "";}
}

