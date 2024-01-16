public class Student {
    String name, stuNo;
    int classes;
    Course mat;
    Course fizik;
    Course kimya;
    double avarage;
    boolean isPass;

    Student(String name, int classes, String stuNo, Course mat, Course fizik, Course kimya) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        this.isPass = false;
    }

    public void addBulkExamNote(int mat, int fizik, int kimya, int verbalMat, int verbalFizik, int verbalKimya) {
        if (mat >= 0 && mat <= 100) {
            this.mat.note = mat;
            this.mat.verbalNote = verbalMat;
        }

        if (fizik >= 0 && fizik <= 100) {
            this.fizik.note = fizik;
            this.fizik.verbalNote = verbalFizik;
        }

        if (kimya >= 0 && kimya <= 100) {
            this.kimya.note = kimya;
            this.kimya.verbalNote = verbalKimya;
        }
    }

    public void calcAvarage() {
        double matAverage = (this.mat.note * (1 - this.mat.verbalWeight)) + (this.mat.verbalNote * this.mat.verbalWeight);
        double fizikAverage = (this.fizik.note * (1 - this.fizik.verbalWeight)) + (this.fizik.verbalNote * this.fizik.verbalWeight);
        double kimyaAverage = (this.kimya.note * (1 - this.kimya.verbalWeight)) + (this.kimya.verbalNote * this.kimya.verbalWeight);
        this.avarage = (matAverage + fizikAverage + kimyaAverage) / 3;
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.avarage > 55;
    }

    public void isPass() {
        if (this.mat.note == 0 || this.fizik.note == 0 || this.kimya.note == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.avarage);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void printNote() {
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + this.mat.note);
        System.out.println("Matematik Sözlü Notu : " + this.mat.verbalNote);
        System.out.println("Fizik Notu : " + this.fizik.note);
        System.out.println("Fizik Sözlü Notu : " + this.fizik.verbalNote);
        System.out.println("Kimya Notu : " + this.kimya.note);
        System.out.println("Kimya Sözlü Notu : " + this.kimya.verbalNote);
    }
}