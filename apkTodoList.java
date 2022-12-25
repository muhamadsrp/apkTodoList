public class apkTodoList {
    public static String[] model = new String[10];
    public static java.util.Scanner scanner =  new java.util.Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("TODOLIST");
        viewShowTodoList();

    }

    /**
     * Menampilkan todo list
     */
    public static void showTodoList() {
        for (var i = 0; i < model.length; i++){
            var todo = model[i];
            var no = i+1;

            if (todo != null){
                System.out.println(no + ". " + todo);
            }
        }

    }

    /**
     * Menambah todo ke list
     */
    public static void addTodoList(String todo){
        // cek apakah model penuh?
        var isFull = true;
        for(int i=0; i<model.length; i++){
            if (model[i] == null){
                //model masih ada yang kosong
                isFull = false;
                break;
            }
        }
        //JIka penuh, kita resize ukuran 2x lipat
        if(isFull){
            var temp = model;
            model = new String[model.length * 2];

            for(int i=0; i<temp.length; i++){
                model[i] = temp[i];
            }
        }
        // tambahkan k eposisi yang data array nya NULL
        for(var i = 0; i<model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    /**
     * Menghapus todo dari list
     */
    public static boolean removeTodoList(int number){
        if((number-1) >= model.length){
            return false;
        }else if(model[number-1] == null){
            return false;
        }else {
            for (int i = (number -1); i < model.length ; i++) {
                if (i == (model.length -1)){
                    model[i] = null;
                }else{
                    model[i] = model[i+1];
                }
            }
            return true;
        }
    }

    /**
     * Inputan
     */
    public  static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var name = input("Nama");
        System.out.println("Hi "+name);

        var channel = input("Cahnnel");
        System.out.println(channel);
    }
    /**
     * Menampilkan view todo list
     */
    public static void viewShowTodoList() {
        while (true){
            showTodoList();
            System.out.println("MENU :");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");

            if (input.equals("1")){
                viewAddTodoList();
            }else if (input.equals("2")){
                viewRemoveTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak ada!");
            }
        }

    }

    /**
     * Menampilkan view menambahkan todo list
     */
    public static void viewAddTodoList(){
        System.out.println("MENAMBAH TODOLIST");

        var todo = input("Todo (x Jika Batal");

        if (todo.equals("x")){
            //Batal
        }else {
            addTodoList(todo);
        }
        viewShowTodoList();

    }

    /**
     * Menampilkan view menghapus todo list
     */
    public static void viewRemoveTodoList(){
        System.out.println("MENGHAPUS TODOLIST");

        var number = input("Nomor yang dihapus (x Jika Batal)");

        if(number.equals("x")){
            //Batal
        } else {
            boolean success = removeTodoList(Integer.valueOf(number));
            if(!success){
                System.out.println("Gagal menghapus todolist : " + number);
            }
        }
    }
}
