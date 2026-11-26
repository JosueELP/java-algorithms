public class Reflection {
    public static void main(String[] args) {
        String example = "This is an example";

        Class<?> exampleClass = getClassInformation(Employee.class);
    }

    public static Class<?> getClassInformation(Class<?> clazz) {
        System.out.printf("Class %s is of type %s \n", clazz.getName(), clazz.getSimpleName());
        System.out.printf("Is primitive: %s\n", clazz.isPrimitive());
        System.out.printf("Package: %s\n", clazz.getPackageName());
        System.out.printf("Is interface: %s\n", clazz.isInterface());
        System.out.printf("Is enum: %s\n", clazz.isEnum());

        return clazz;
    }

    public static class Employee {
        public String name;
        public String jobRole;

        public String getName() {
            return name;
        }

        public String getJobRole() {
            return jobRole;
        }
    }
}
