package com.suek.ex14optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 4) 상수화된 변수(final 상수)
    final int MENU_AAA= 1;    //final 은 대문자로 되어있음
    final int MENU_BBB= 2;

    // 1)  이 액티비티가 처음 생성되면 자동으로 호출되는 콜백메소드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //  2)  onCreate() 메소드가 실행된 후
    //자동으로 OptionMenu 를 만드는 작업을 하는
    //이 콜백메소드가 발동함 invoke
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //자동으로 "aaa" 라는 글씨를 가진 MenuItem 객체 생성 및 추가
        //menu.add("aaa");

        //방법1) 메뉴아이템 추가를 Java 언어의 add()메소드로 하기!!
        //옵션메뉴에 들어갈 메뉴아이템을 생성하여 추가하면 됨
        //group 없음(0), 아이템 Id(1), order 나오는 순서를 바꿔주고 싶을때
        //menu.add(0, 1, 0, "aaa");
        //menu.add(0, 2, 0, "bbb");



        //방법2) 메뉴항목 설계를 XML 언어로 하고 이를 JAVA 에서 객체로 만들어 적용
        //res/menu/option.xml 문서를 만들고 그 안에 메뉴항목들을 설계
        //menu 포더의 xml 문서를 읽어와서 Menu 객체로 만들어(부풀리는)주 객체(MenuInflater)에게 만들어달라고 요청
        MenuInflater menuInflater= this.getMenuInflater();     //여기서 this 는 액티비티(context 상속받음)
        menuInflater.inflate(R.menu.option, menu);    //R.menu.option 를 뒤에있는 menu 에 대입



        return super.onCreateOptionsMenu(menu);
    }






    // 방법1) 을 이용한 문서**********(java 이용)
    //  3)  OptionMenu 의 메뉴항목(MenuItem)을 선택했을 때
    // 자동으로 실행되는 콜백메소드 -OptionsItemSelected

    /*@Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        // 선택한 MenuItem 객체를 파라미터(매개변수: Item)으로 전달받음
        // 전달된 item 객체의 id를 이용하여/ 식별하여 원하는 작업을 수행
        int id= item.getItemId();  //위의 id가 1,2였으니 정수형 int 로 받는다.
        switch (id){
            case MENU_AAA:    //== case 1:
                Toast t= Toast.makeText(this, "AAA", Toast.LENGTH_SHORT);
                t.show();
                break;


            case MENU_BBB:    //== case 2:
                Toast.makeText(this,"BBB", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }*/





    // 방법2) 을 이용한 문서**********(xml 이용)
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        // 선택한 MenuItem 객체를 파라미터(매개변수: Item)으로 전달받음
        // 전달된 item 객체의 id를 이용하여/ 식별하여 원하는 작업을 수행
        int id= item.getItemId();  //위의 id가 1,2였으니 정수형 int 로 받는다.
        switch (id){
            case R.id.menu_search:    //== case 1:
                Toast t= Toast.makeText(this, "Search", Toast.LENGTH_SHORT);
                t.show();
                break;


            case R.id.menu_add:    //== case 2:
                Toast.makeText(this,"Add", Toast.LENGTH_SHORT).show();
                break;
        }



        return super.onOptionsItemSelected(item);
    }
}
