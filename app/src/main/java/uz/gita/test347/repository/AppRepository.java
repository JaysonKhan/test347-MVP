package uz.gita.test347.repository;

import android.content.Context;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import uz.gita.test347.model.TestData;

public class AppRepository {
    private List<TestData> list;
    private static AppRepository instance;

    public static AppRepository getInstance() {
        if (instance == null) instance = new AppRepository();
        return instance;
    }

    public static void init(Context context) {
        instance = new AppRepository();
    }

    AppRepository() {
        loadTest();
    }

    private void loadTest() {
        list = new ArrayList<>(5);
        list.add(new TestData("5 * 5 =? ", "20", "25", "30", "35", "25"));
        list.add(new TestData("Quyidagilardan qaysi biri primitive toifa hisoblanadi?", "Int", "String", "int", "Character", "int"));
        list.add(new TestData("Faqat sonor undoshlar qatnashgan so'zlar qatorini toping.", "mosh, mos, makon", "shag'al, nog'ora, mog'or", "malol, marom, marmar", "jang, mo'g'ul, nov", "malol, marom, marmar"));
        list.add(new TestData("Qaysi so'z tarkibida ikki jarangli undosh orasida yuqori tor unli kelgan yopiq bo'g'in bor?", "suyuqlik", "quchoqlamoq", "ko'pburchak", "besaranjom", "quchoqlamoq"));
        list.add(new TestData("Bo'g'inlarga ajratish bilan asos va qo'shimchalarga ajratish teng kelmaydigan qatorni toping.", "fikrim, baxtim", "boshga, toshda", "shahri, kuchli", "faxri, aqldan", "fikrim, baxtim"));
        list.add(new TestData("Quyidagi sonlardan eng kattasini toping:", "15", "25", "20", "10", "25"));
        list.add(new TestData("Java dasturlash tili qaysi davlatda yaratilgan?", "AQSH", "Yaponiya", "Germaniya", "Fransiya", "AQSH"));
        list.add(new TestData("O'zbekiston Poytaxti qayer?", "Toshkent", "Samarqand", "Buxoro", "Andijon", "Toshkent"));
        list.add(new TestData("Quyidagi operatorlar qaysi bo'lib xatolikni chiqaradi?", "&&", "||", "!", "&", "&"));
        list.add(new TestData("3 * 3 = ?", "6", "9", "12", "15", "9"));
        list.add(new TestData("Java da 7-8 marta amalga oshiriladigan metod:", "main", "finalize", "run", "constructor", "main"));
        list.add(new TestData("O'zbekiston bayrog'i qaysi ranglardan iborat?", "Oq, Qora, Yashil", "Qizil, Oq, Qora", "Oq, Sariq, Qora", "Ko'k, Qizil, Oq, Yashil", "Ko'k, Qizil, Oq, Yashil"));
        list.add(new TestData("6 / 2 * (1 + 2) = ?", "1", "3", "6", "9", "9"));
        list.add(new TestData("Java dasturlash tili qaysi yilga qadar \"Oak\" nomi bilan mashhur edi?", "1991", "1995", "2000", "2005", "1995"));
        list.add(new TestData("Quyidagi operatorlardan qaysi operator o'zgaruvchilar qiymatini o'zgartirishi mumkin?", "++", "--", "+=", "-=", "++"));
        list.add(new TestData("20 / 5 * 3 = ?", "6", "9", "12", "15", "12"));
        list.add(new TestData("Java dasturlash tili qaysi tilda yozilgan?", "Pyton", "Java", "PHP", "C++", "Java"));
        list.add(new TestData("Java dasturlash tili qaysi tuzatilgan taqvimda yaratilgan?", "1995", "2000", "2005", "2010", "1995"));
        list.add(new TestData("Quyosh chiqishi va botirinlar ko'rishishi qancha farq qiladi?", "3 daqiqa", "3 soat", "3 kun", "3 yil", "3 daqiqa"));
        list.add(new TestData("O'zbekiston poytaxti qayer?", "Andijon", "Buxoro", "Namangan", "Toshkent", "Toshkent"));
        list.add(new TestData("Qudrat shunday qiladi: pastdagi ishlar bo'lsa, yuqoridagi insonning mana shunday?", "Qo'rqmagan", "Juda atrof-muhitda", "Juda faqir", "Juda salbiy", "Juda atrof-muhitda"));
        list.add(new TestData("Zilzilaning chenagi qancha?", "10 000 km", "15 000 km", "20 000 km", "25 000 km", "40 075 km"));
        list.add(new TestData("Dunyoda eng ko'p foydalaniladigan tili qaysi?", "Angliya", "Fransiya", "Germaniya", "Ispaniya", "Angliya"));
        list.add(new TestData("Aqlli bola so'zdan nima ma'noda foydalanadi?", "O'ziga xos", "Qo'rqoqda", "Issiqda", "Kulgili", "O'ziga xos"));
        list.add(new TestData("Qalampir uchun xalqimizda foydalaniladigan so'z?", "Balmay", "Halqa", "Dalolatli", "Istiqlol", "Balmay"));
        list.add(new TestData("G'arbda ilk chet elda qaysi yili qo'shilgan?", "1901", "1900", "1905", "1910", "1900"));
        list.add(new TestData("Avstraliya xalqining nomi?", "Aborigin", "Eskimo", "Samoan", "Inka", "Aborigin"));
        list.add(new TestData("Dengiz sathidan yuqori ko'rsatuvchi qaysi tog?", "Elbrus", "Himaloy", "Andlar", "Alp", "Himaloy"));
        list.add(new TestData("Kanada poytaxti?", "Montreal", "Toronto", "Vancouver", "Ottawa", "Ottawa"));
        list.add(new TestData("Arqon bilan sharqonning uzoqligi qancha?", "30 000 km", "40 000 km", "50 000 km", "60 000 km", "40 000 km"));
        list.add(new TestData("Toshkentda eng yuqori binoning balandligi qancha?", "120 m", "220 m", "320 m", "420 m", "320 m"));
        list.add(new TestData("Lal zarafshan necha milliard yil avvali bor edi?", "10", "50", "100", "500", "50"));
        list.add(new TestData("Quyidagilardan qaysi biri boolean tipiga to'g'ri keladi?", "true", "1", "0", "1.5", "true"));
        list.add(new TestData("Java dasturlash tili dasturi qanday e'lon qilingan?", "Microsoft tomonidan", "Sun Microsystems tomonidan", "Oracle tomonidan", "Apple tomonidan", "Sun Microsystems tomonidan"));
        list.add(new TestData("Java dasturlash tili mazmuni qanday?", "Protsedural", "Modul o'riented", "Nes'oya o'riented", "To'plam o'riented", "Nes'oya o'riented"));
        list.add(new TestData("Kichik Osiyoda birinchi marta temirdan tayyorlangan mahsulotlardan foydalanishni boshlagan odamlarni ko'rsating.", "Xettlar", "Urartu", "Forslar", "Finikiyaliklar", "Finikiyaliklar"));
        list.add(new TestData("Portugallarning muvaffaqiyatli geografik kashfiyotlari kimning nomi bilan bog'liq?", "Vasko da Gama", "Genrix dengizchi", "Bartolomeu Dias", "Fernando Magellan", "Vasko da Gama"));
        list.add(new TestData("Myunxen bitimini imzolamagan davlat rahbarini ko‘rsating.", "Adolf Gitler", "Vudro Vilson", "Nevill Chemberlen", "Benito Mussolini", "Nevill Chemberlen"));
        list.add(new TestData("Jek Londonning qaysi asari \"Martin Iden\" romanida qatnashgan?", "Martin Iden", "Sodiq", "Mon-Oriol", "Mayor Barbara", "Martin Iden"));
        list.add(new TestData("Quyidagi hukmdorlardan qaysi biri qadimgi Misrni bosib olgan?", "Kir II", "Kambiza II", "Gilgamish", "Ashoka", "Kambiza II"));
        list.add(new TestData("Arifmetik o'rtacha qanday hisoblanadi?", "Bir nechta sonning yig'indisining soni bo'lganda", "Sonlar ketma-ketligining o'rta arifmetigi", "Har bir sondan olingan n ta son yig'indisi bo'lganda", "Bir nechta sonning ko'paytmasi bo'lganda", "Sonlar ketma-ketligining o'rta arifmetigi"));
        list.add(new TestData("Diskret funksiya nima?", "Aloqador qiymatlar bilan ifodalangan o'zgaruvchilar", "Murakkab funksiyalar", "Funksiyalarning o'rni bilan aloqador bo'lmagan qiymatlar", "Funksiyalar yig'indisining nisbiy qiymati", "Funksiyalarning o'rni bilan aloqador bo'lmagan qiymatlar"));
        list.add(new TestData("Logarifmni hisoblash formula nima?", "loga(b*c) = loga(b) + loga(c)", "loga(b^c) = c * loga(b)", "loga(b/c) = loga(b) - loga(c)", "b = a^loga(b)", "loga(b*c) = loga(b) + loga(c)"));
        list.add(new TestData("Sinus funksiyasi qanday hisoblanadi?", "Quti kordinatalarida", "Polar kordinatalarida", "Cilindr kordinatalarida", "Sfera kordinatalarida", "Polar kordinatalarida"));
        list.add(new TestData("Pifagor teoremasi qanday ifodalangan?", "a^2 + b^2 = c^2", "a + b = c", "a^2 - b^2 = c^2", "a * b = c", "a^2 + b^2 = c^2"));
        list.add(new TestData("Xisoblashda nechta amal bajariladi?", "3 ta", "2 ta", "4 ta", "5 ta", "3 ta"));
        list.add(new TestData("2x + 3 = 13 tenglama yechimini toping?", "x = 5", "x = 6", "x = 7", "x = 8", "x = 5"));
        list.add(new TestData("Kvadrat tenglama formulasi qanday?", "x = (-b +/- sqrt(b^2 - 4ac)) / 2a", "x = -b / a", "x = -c / b", "x = a + b + c", "x = (-b +/- sqrt(b^2 - 4ac)) / 2a"));
        list.add(new TestData("Grafikning oxirgi noqta nima?", "Maxsus nuqtalar", "Birorta nuqta", "Kordinatalarning bir xil qiymati", "Kordinatalarning bir xil qiymati", "Maxsus nuqtalar"));
        Collections.shuffle(list);

    }

    public void shuffle() {
        Collections.shuffle(list);
    }

    public List<TestData> getNeedDataByCount(int max_count) {
        return list.subList(0, max_count);
    }
}

