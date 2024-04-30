<h1 align="center">Hayvanat Bahçesi Projesi</h1>

<p>500'e 500'lük bir alanda yaşayan 30 koyun (15 erkek,15 dişi), 10 inek (5 erkek,5 dişi), 10 tavuk,10 kurt (5 dişi,5 erkek) 10 horoz, 8 aslan (4 erkek, 4 dişi) ve 1 avcı bulunmaktadır.</p>

- Hayvanlardan;
- koyun 2 birim,
- kurt 3 birim,
- inek 2 birim,
- tavuk 1 birim,
- horoz 1 birim,
- aslan 4 birim,
- avcı 1 birim rasgele şekilde hareket etmektedir ancak alanın dışına çıkamamaktadır.

<p>Hareketler rastgele olup yukarı aşağı sağ sol olmak üzere 4 yöne doğru hareket ederler. eğer gidilebilecek yönlerin hepsi doluysa ya da alan dışıysa  hareeket etmezler</p>



- kurt kendisine 4 birim yakınındaki koyun, tavuk, horoz'u avlayabiliyor.
- aslan kendisine 5 birim yakınlıktaki inek, koyun'u avlayabiliyor.
- avcı da kendisine 8 birim yakınlıktaki hayvanlardan herhangi birisini avlayabiliyor.
- avlananlar her seferinde sadece menzilindeki avlardan rastgele 1 tanesini avlarlar


aynı cins farklı cinsiyetteki hayvanlar birbirine 3 birim yakınlaştığı zaman random cinsiyetli ve aynı cins bir hayvan meydana gelmektedir.
  öncelikli olarak yeni oluşacak hayvan dişi hayvanın  hemen etrafında oluşur etrafı tamamen doluysa hemen sonraki alanda oluşur. Aşağıda gösterilen şekilde herseferinde dolur olursa bir adım daha dışa çıkılır

D= dişi hayvan  N=yeni hayvanın gelebileceği noktalar  F=Dolu alanlar  O=boş alanlar

![image](https://github.com/AliHanBtmz/Java-projects/assets/132774344/b2185a42-f929-4213-8583-0f61b636f66d)


1000 birim hareket sonunda hayvanların sayısının bulunduğu bir console application yazılması beklenmektedir.
Çalışma sırası  şu şekilde

    1-başlangıç taki hayvanlar yerleştirilir
    2-hayvanlar hareket eder.
    3-avcı ve avlanabilen hayvanlar avlanır.
    4-yeni hayvanlar oluşabiliyorsa oluşur.

bu sıra birim hareket sayısı 1000 olana kadar devam eder
