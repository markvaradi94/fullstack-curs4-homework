package app.exercise2;

sealed interface Animal permits Cat, Dog, Bird, Insects {
    String say();
}

final class Dog implements Animal {
    @Override
    public String say() {
        return "woof bro";
    }
}

record Cat(String name) implements Animal {
    @Override
    public String say() {
        return "meow bro";
    }
}

