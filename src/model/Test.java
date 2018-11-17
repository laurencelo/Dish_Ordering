//package model;
//
//public class Test {
//    public static void testStaffLogin() {
//
//        // staff login wigh correct password
//        Staff correctStaff = new Staff();
//        String correctPassword = "test12345";
//        correctStaff.login(correctPassword);
//        if (correctStaff.getisAdmin()) {
//            System.out.println("Log in successfully");
//        } else {
//            System.out.println("Wrong password!");
//        }
//        // staff login with wrong password
//        Staff wrongStaff = new Staff();
//        String wrongPassword = "wrongpwd";
//        wrongStaff.login(wrongPassword);
//        if (wrongStaff.getisAdmin()) {
//            System.out.println("Log in successfully");
//        } else {
//            System.out.println("Wrong password!");
//        }
//    }
//
//    public static void testManage() {
//        Staff staff = new Staff();
//        staff.login("test12345");
//        // add dish test
//        staff.manageMenu("Pizza", 1, 1.00);
//        staff.getMenu().forEach(dish -> {
//            System.out.println("Add dish test");
//            printDishInfo(dish);
//        });
//        // update Dish name test
//        System.out.println("Update dish name test");
//        staff.manageMenu("Pizza", "Apple");
//        staff.getMenu().forEach(dish -> {
//            printDishInfo(dish);
//        });
//        // update dish inventory test
//        System.out.println("Update dish inventory test");
//        staff.manageMenu("Apple", 10);
//        staff.getMenu().forEach(dish -> {
//            printDishInfo(dish);
//        });
//        // update dish price test
//        System.out.println("Update dish price test");
//        staff.manageMenu("Apple", 5.00);
//        staff.getMenu().forEach(dish -> {
//            printDishInfo(dish);
//        });
//        // delete dish test
//        System.out.println("Delete dish test");
//        staff.manageMenu("Apple");
//        if (staff.getMenu().size() == 0) {
//            System.out.println("empty");
//        } else {
//            staff.getMenu().forEach(dish -> {
//                printDishInfo(dish);
//            });
//        }
//    }
//
//    public static void printDishInfo(Dish dish) {
//        System.out.println("Dish name: " + dish.getDishName() + "\nDish Inventory: " + dish.getInventory()
//                + "\nDish Price: " + dish.getPrice() + "\n");
//    }
//
//    public static void main(String[] args) {
//        testStaffLogin();
//        testManage();
//    }
//}