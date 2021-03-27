package app.exercise2;

non-sealed interface Insects extends Animal {
    record LadyBug() implements Insects {

        @Override
        public String say() {
            return "also a mr bug";
        }
    }

    class Fly implements Insects {
        @Override
        public String say() {
            return "bzzzz";
        }
    }
}
