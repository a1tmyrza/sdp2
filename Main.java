import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static Coffee coffee;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Coffee Order System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        JLabel coffeeLabel = new JLabel("Choose a coffee type:");
        coffeeLabel.setBounds(50, 10, 250, 50);
        panel.add(coffeeLabel);

        String[] coffeeTypes = {"Black Coffee", "Cappuccino", "Latte", "Red Eye"};
        JComboBox<String> coffeeComboBox = new JComboBox<>(coffeeTypes);
        coffeeComboBox.setBounds(200, 20, 150, 25);
        panel.add(coffeeComboBox);

        JLabel decoratorLabel = new JLabel("Add Decorators:");
        decoratorLabel.setBounds(50, 60, 150, 25);
        panel.add(decoratorLabel);

        JCheckBox milkCheckbox = new JCheckBox("Milk");
        milkCheckbox.setBounds(200, 60, 80, 25);
        panel.add(milkCheckbox);

        JCheckBox sugarCheckbox = new JCheckBox("Sugar");
        sugarCheckbox.setBounds(280, 60, 80, 25);
        panel.add(sugarCheckbox);

        JCheckBox syrupCheckbox = new JCheckBox("Syrup");
        syrupCheckbox.setBounds(360, 60, 80, 25);
        panel.add(syrupCheckbox);

        JButton orderButton = new JButton("Place Order");
        orderButton.setBounds(150, 100, 100, 25);
        panel.add(orderButton);

        JLabel resultLabel = new JLabel();
        resultLabel.setBounds(50, 140, 300, 25);
        panel.add(resultLabel);

        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCoffee = (String) coffeeComboBox.getSelectedItem();
                switch (selectedCoffee) {
                    case "Black Coffee":
                        coffee = new BlackCoffee();
                        break;
                    case "Cappuccino":
                        coffee = new Cappuccino();
                        break;
                    case "Latte":
                        coffee = new Latte();
                        break;
                    case "Red Eye":
                        coffee = new RedEye();
                        break;
                }

                if (milkCheckbox.isSelected()) {
                    coffee = new MilkDecorator(coffee);
                }
                if (sugarCheckbox.isSelected()) {
                    coffee = new SugarDecorator(coffee);
                }
                if (syrupCheckbox.isSelected()) {
                    coffee = new SyrupDecorator(coffee);
                }

                String orderDescription = "Your order: " + coffee.getDescription() +
                        "<br>Total cost: " + coffee.cost() + "тг";
                resultLabel.setText("<html>" + orderDescription + "</html>");
            }
        });

        frame.setVisible(true);
    }
}
