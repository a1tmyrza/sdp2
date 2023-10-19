class SyrupDecorator extends CoffeeDecorator {
    public SyrupDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return coffee.getDescription() + ", Syrup";
    }

    public double cost() {
        return coffee.cost() + 150.0;
    }
}