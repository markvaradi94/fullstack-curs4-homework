package app.exercise2;

sealed interface Bird extends Animal permits Canary, Parrot, Chicken {}

record Canary(String name) implements Bird {
    @Override
    public String say() {
        return "what does the canary say?";
    }
}

final class Parrot implements Bird {
    @Override
    public String say() {
        return "parrot 4 lyf";
    }
}

non-sealed class Chicken implements Bird {
    @Override
    public String say() {
        return "kfc";
    }
}
