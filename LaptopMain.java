import java.util.*;
import java.util.Scanner;

public class LaptopMain {
    public static void main (String [] args){
        Scanner scanner = new Scanner(System.in);

        Laptop laptop1 = new Laptop("HP Pavilion", 8, 512, "Windows 10", "Silver");
        Laptop laptop2 = new Laptop("Dell XPS", 16, 1024, "Windows 11", "Black");
        Laptop laptop3 = new Laptop("Lenovo ThinkPad", 16, 256, "Ubuntu", "Black");
        Laptop laptop4 = new Laptop("MacBook Pro", 32, 512, "macOS", "Space Gray");
        Laptop laptop5 = new Laptop("HP Pavilion", 8, 512, "Windows 10", "Silver");

        Set<Laptop> laptops = new HashSet<>(Arrays.asList(laptop1,laptop2,laptop3,laptop4,laptop5));

        // Выводим все доступные ноутбуки
        System.out.println("Доступные ноутбуки:");
        for (Laptop laptop : laptops) {
            System.out.println(laptop);
        }
        // Запрос фильтрации
        Map<String, Object> filters = new HashMap<>();

        while (true) {
            System.out.println("\nВведите цифру, соответствующую необходимому критерию:");
            System.out.println("1 - ОЗУ");
            System.out.println("2 - Объем ЖД");
            System.out.println("3 - Операционная система");
            System.out.println("4 - Цвет");
            System.out.println("5 - Применить фильтры и выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 5) {
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("Доступные значения ОЗУ: " + getRamOptions(laptops));
                    System.out.print("Введите минимальное значение ОЗУ (ГБ): ");
                    int ram = scanner.nextInt();
                    filters.put("RAM", ram);
                    break;
                case 2:
                    System.out.println("Доступные значения объема ЖД: " + getHddOptions(laptops));
                    System.out.print("Введите минимальное значение объема ЖД (ГБ): ");
                    int hdd = scanner.nextInt();
                    filters.put("HDD", hdd);
                    break;
                case 3:
                    System.out.println("Доступные операционные системы: " + getOsOptions(laptops));
                    System.out.print("Введите операционную систему: ");
                    String os = scanner.nextLine();
                    filters.put("OS", os);
                    break;
                case 4:
                    System.out.println("Доступные цвета: " + getColorOptions(laptops));
                    System.out.print("Введите цвет: ");
                    String color = scanner.nextLine();
                    filters.put("Color", color);
                    break;
                default:
                    System.out.println("Неверный ввод. Попробуйте снова.");
                    break;
            }
        }

        System.out.println("\nПрименение фильтров:");
        filterLaptops(laptops, filters);

        scanner.close(); // Закрываем сканер
    }

    private static Set<Integer> getRamOptions(Set<Laptop> laptops) {
        Set<Integer> ramOptions = new HashSet<>();
        for (Laptop laptop : laptops) {
            ramOptions.add(laptop.getRamGb());
        }
        return ramOptions;
    }

    private static Set<Integer> getHddOptions(Set<Laptop> laptops) {
        Set<Integer> hddOptions = new HashSet<>();
        for (Laptop laptop : laptops) {
            hddOptions.add(laptop.getHddGb());
        }
        return hddOptions;
    }

    private static Set<String> getOsOptions(Set<Laptop> laptops) {
        Set<String> osOptions = new HashSet<>();
        for (Laptop laptop : laptops) {
            osOptions.add(laptop.getOs());
        }
        return osOptions;
    }

    private static Set<String> getColorOptions(Set<Laptop> laptops) {
        Set<String> colorOptions = new HashSet<>();
        for (Laptop laptop : laptops) {
            colorOptions.add(laptop.getColor());
        }
        return colorOptions;
    }

    private static void filterLaptops(Set<Laptop> laptops, Map<String, Object> filters) {
        List<Laptop> filteredLaptops = new ArrayList<>();

        for (Laptop laptop : laptops) {
            boolean passesFilter = true;

            for (Map.Entry<String, Object> entry : filters.entrySet()) {
                String criteria = entry.getKey();
                Object value = entry.getValue();

                switch (criteria) {
                    case "RAM":
                        if (laptop.getRamGb() < (int) value) {
                            passesFilter = false;
                        }
                        break;
                    case "HDD":
                        if (laptop.getHddGb() < (int) value) {
                            passesFilter = false;
                        }
                        break;
                    case "OS":
                        if (!laptop.getOs().equalsIgnoreCase((String) value)) {
                            passesFilter = false;
                        }
                        break;
                    case "Color":
                        if (!laptop.getColor().equalsIgnoreCase((String) value)) {
                            passesFilter = false;
                        }
                        break;
                    default:
                        System.out.println("Неизвестные критерии: " + criteria);
                        break;
                }

                if (!passesFilter) {
                    break;
                }
            }

            if (passesFilter) {
                filteredLaptops.add(laptop);
            }
        }

        if (filteredLaptops.isEmpty()) {
            System.out.println("Ни один ноутбук не соответствует заданным критериям.");
        } else {
            System.out.println("Отфильтрованные ноутбуки:");
            for (Laptop laptop : filteredLaptops) {
                System.out.println(laptop);
            }
        }
    }
}

