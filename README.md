Android에서 스타일(Style)과 테마(Theme)는 앱의 UI 디자인을 일관되게 유지하는 데 중요한 역할을 합니다. 이 두 가지는 비슷해 보일 수 있지만, 사용 목적과 적용 범위에서 차이가 있습니다.

스타일(Style)
정의: 스타일은 특정 뷰(View) 또는 위젯에 적용할 수 있는 속성들의 집합입니다. 예를 들어, 버튼의 글꼴, 배경색, 글자색 등을 정의할 수 있습니다.
목적: 스타일은 코드의 재사용성을 높이고, XML 레이아웃 파일의 가독성을 향상시키기 위해 사용됩니다. 비슷한 속성을 여러 뷰에 반복적으로 적용해야 할 때 스타일을 정의하여 코드 중복을 줄일 수 있습니다.
사용 예: <style> 태그를 사용하여 styles.xml 파일 내에 스타일을 정의하고, 뷰에 android:style="@style/YourStyleName" 속성을 추가하여 적용할 수 있습니다.
테마(Theme)
정의: 테마는 앱 전체 또는 액티비티 전체에 적용되는 속성들의 집합입니다. 테마를 통해 앱의 전반적인 색상 스키마, 글꼴 스타일, 버튼 스타일 등을 정의할 수 있습니다.
목적: 테마는 앱의 일관된 외관을 제공하고, 사용자 경험을 향상시키기 위해 사용됩니다. 한 번의 설정으로 앱 전체에 대한 디자인 요소를 통일할 수 있습니다.
사용 예: AndroidManifest.xml 파일에서 <application> 태그의 android:theme 속성을 통해 앱 전체에 적용할 테마를 지정할 수 있고, <activity> 태그의 android:theme 속성을 통해 특정 액티비티에만 다른 테마를 적용할 수도 있습니다.
스타일과 테마의 차이점
적용 범위: 스타일은 개별 뷰나 위젯에 적용되는 반면, 테마는 앱 전체 또는 액티비티 전체에 적용됩니다.
목적과 사용성: 스타일은 코드의 재사용성과 가독성을 위해 사용되며, 테마는 앱의 전반적인 디자인과 일관성을 유지하기 위해 사용됩니다.
Android 앱 개발에서 스타일과 테마는 사용자에게 더 나은 시각적 경험을 제공하고, 개발 과정에서의 효율성을 높이는 데 중요한 도구입니다.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Android에서의 Guideline은 ConstraintLayout 내에서 UI 구성 요소를 정렬하는 데 도움을 주는 비시각적 가이드라인입니다. 이는 화면을 여러 섹션으로 나누고, 이러한 섹션을 기준으로 다른 뷰들을 정렬할 때 유용하게 사용됩니다. Guideline은 실제로 사용자 인터페이스에 보이지 않으며, 디자인 시에만 보여 UI 구성에 도움을 줍니다.

주요 특징
비시각적: 런타임에 사용자에게 보이지 않으며, 오직 디자인 타임에만 보입니다.
유연성: ConstraintLayout 내의 다른 뷰들을 다양한 방향과 위치에서 정렬할 기준점으로 사용할 수 있습니다.
조정 가능: 가로, 세로, 그리고 각도(백분율 기준)로 설정할 수 있어 유연한 레이아웃 디자인이 가능합니다.
사용 방법
가로(horizontal) Guideline: 세로 방향의 정렬을 도와주며, 레이아웃의 상단이나 하단으로부터의 거리를 지정하여 사용합니다.
세로(vertical) Guideline: 가로 방향의 정렬을 도와주며, 레이아웃의 좌측이나 우측으로부터의 거리를 지정하여 사용합니다.
각도(percent) Guideline: 가로나 세로 방향에 대해 백분율을 기준으로 위치를 지정합니다. 이는 화면 크기가 변해도 일정 비율로 위치를 유지할 수 있게 해줍니다.
XML에서의 사용 예
xml


<androidx.constraintlayout.widget.ConstraintLayout ... >

    <androidx.constraintlayout.widget.Guideline
        android:id="@+id/guideline"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        app:layout_constraintGuide_begin="100dp" />

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintStart_toStartOf="@id/guideline"
        android:text="예제 텍스트" />

</androidx.constraintlayout.widget.ConstraintLayout>
이 예에서 Guideline은 레이아웃의 시작부터 100dp의 위치에 세로 방향으로 설정되어 있습니다. TextView는 이 Guideline을 기준으로 시작 위치를 정렬하고 있습니다.

Guideline을 사용함으로써, 디자인이 더 유연하고, 코드의 중복을 줄이며, 다양한 화면 크기에 대응하는 반응형 레이아웃을 구현하는 데 도움이 됩니다.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Layer와 Group은 Android의 XML에서 사용되는 개념으로, 각각 다른 목적과 사용 방식을 가지고 있습니다.

Layer (Layer-list)
목적 및 사용법: Layer (특히 layer-list에서 사용됨)는 다양한 아이템들(주로 이미지)을 하나의 단위로 층층이 쌓아 올리는 데 사용됩니다. 이는 복잡한 디자인을 구현할 때 유용합니다. 각각의 레이어는 독립적인 속성을 가지며, 위치나 크기 등을 조정할 수 있습니다.
적용 분야: 주로 배경, 버튼, 또는 복합적인 이미지 리소스를 만들 때 사용됩니다.
Group
목적 및 사용법: Group은 ConstraintLayout 내에서 여러 뷰를 그룹화하여 그룹 전체의 속성(예: 가시성)을 한 번에 조작할 수 있게 해줍니다. 실제 뷰의 배치나 크기를 변경하지 않고, 속성만을 조정하는 데 쓰입니다.
적용 분야: 뷰의 가시성을 그룹 단위로 제어하거나, 여러 뷰에 공통된 속성을 적용할 때 유용합니다.
차이점 요약
적용 범위: Layer는 주로 디자인 요소들을 층으로 구성할 때 사용되며, Group은 ConstraintLayout에서 뷰들의 속성을 그룹화하여 제어할 때 사용됩니다.
시각적 요소: Layer는 시각적인 요소들을 층으로 쌓아 올리는 데 초점을 맞추고, Group은 뷰들의 시각적인 배치를 변경하지 않고 속성만을 조정합니다.
사용 목적: Layer는 복잡한 시각적 디자인을 구현하는 데 사용되며, Group은 뷰들의 속성(가시성 등)을 효과적으로 관리하는 데 사용됩니다.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Android에서 Intent는 애플리케이션 컴포넌트 간의 통신을 위한 메시징 객체입니다. 액티비티 간의 데이터 전달, 서비스 시작 및 브로드캐스트 수신자 호출 등 다양한 작업을 수행하는 데 사용됩니다. Intent는 명시적(Explicit)과 암시적(Implicit) 두 가지 주요 유형이 있습니다.

명시적 Intent
명시적 Intent는 애플리케이션 내에서 시작할 컴포넌트(예: 다른 액티비티)를 명확하게 지정할 때 사용됩니다. 주로 애플리케이션 내부에서 액티비티, 서비스 등을 명확하게 호출할 때 사용됩니다.

java


Intent intent = new Intent(this, SecondActivity.class);
startActivity(intent);
위 코드는 현재 액티비티에서 SecondActivity라는 새 액티비티를 시작하는 예시입니다.

암시적 Intent
암시적 Intent는 특정 작업을 수행할 수 있는 애플리케이션 컴포넌트를 시스템에 요청하지만, 그 컴포넌트가 구체적으로 어떤 것인지는 지정하지 않습니다. 이는 여러 앱이 공통된 작업을 처리할 수 있도록 할 때 사용됩니다. 예를 들어, 사용자가 웹 링크를 열거나 이메일을 보내고 싶을 때, 암시적 Intent를 사용하여 사용 가능한 모든 앱 목록을 사용자에게 제시할 수 있습니다.

java


Intent intent = new Intent(Intent.ACTION_VIEW);
intent.setData(Uri.parse("http://www.example.com"));
startActivity(intent);
위 코드는 웹 브라우저를 열어서 지정된 URL을 보여주는 예시입니다.

Intent의 주요 구성요소
Action: 수행하려는 기본 작업을 나타냅니다. 예: ACTION_VIEW, ACTION_EDIT.
Data: 작업을 수행할 데이터의 URI입니다. 예: content://contacts/people/1.
Category: Intent가 속하는 카테고리를 지정합니다. 이를 통해 어떤 컴포넌트가 이 Intent를 처리할 수 있는지 제한할 수 있습니다.
Extras: 키-값 쌍으로 이루어진 추가 데이터를 전달합니다. 일반적으로 액티비티 간에 데이터를 전달할 때 사용됩니다.
Flags: 인텐트 작동 방식에 영향을 미치는 다양한 플래그입니다. 예: FLAG_ACTIVITY_NEW_TASK, FLAG_ACTIVITY_CLEAR_TOP.
Intent는 Android에서 다른 컴포넌트와의 상호작용을 위한 핵심적인 메커니즘입니다. 다양한 용도와 기능을 제공하여 앱의 구성 요소 간 통신을 용이하게 합니다.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Android의 AndroidManifest.xml 파일은 모든 Android 애플리케이션의 중심에 위치하며, 애플리케이션에 대한 필수 정보를 시스템에 제공합니다. 이 파일은 애플리케이션의 구조, 각 구성 요소의 성격, 애플리케이션이 필요로 하는 권한, 사용하는 라이브러리 등을 정의합니다. AndroidManifest.xml의 주요 기능은 다음과 같습니다.

애플리케이션 구성 요소 정의
액티비티(Activity): 사용자가 애플리케이션과 상호작용하는 화면. AndroidManifest.xml에는 애플리케이션의 모든 액티비티가 선언되어야 하며, 주요 액티비티(애플리케이션 진입점)는 특별히 지정됩니다.
서비스(Service): 백그라운드에서 실행되는 장기 실행 작업. 사용자 인터페이스 없이 데이터 다운로드, 업로드 등의 작업을 수행할 때 사용됩니다.
브로드캐스트 리시버(Broadcast Receiver): 시스템이나 다른 애플리케이션으로부터 발송된 브로드캐스트 메시지를 수신합니다.
콘텐트 프로바이더(Content Provider): 애플리케이션 데이터를 다른 애플리케이션과 공유할 수 있게 해주는 구성 요소입니다.
권한(Permissions)
애플리케이션이 시스템 또는 다른 애플리케이션의 보호된 부분에 접근하기 위해 필요한 권한을 선언합니다. 예를 들어, 카메라에 접근하거나 인터넷을 사용하려면 해당 권한을 AndroidManifest.xml에 선언해야 합니다.

인텐트 필터(Intent Filters)
특정 액티비티, 서비스, 브로드캐스트 리시버가 처리할 인텐트의 유형을 선언합니다. 예를 들어, 웹 URL을 처리하도록 액티비티를 선언할 수 있습니다.

애플리케이션 메타데이터
애플리케이션 레벨에서 사용할 추가 정보를 제공합니다. 예를 들어, Google Maps API 키와 같은 정보를 여기에 포함시킬 수 있습니다.

최소 및 대상 SDK 버전
애플리케이션이 실행될 수 있는 Android 버전을 정의합니다. 최소 SDK 버전은 애플리케이션이 지원하는 최소 Android 버전을 나타내며, 대상 SDK 버전은 애플리케이션이 최적화된 Android 버전을 나타냅니다.

AndroidManifest.xml은 애플리케이션의 기능과 구조를 시스템에 선언하는 중요한 역할을 하며, 애플리케이션 개발의 초기 단계에서부터 신중하게 관리되어야 합니다.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
안드로이드에서 Spinner 위젯은 사용자에게 드롭다운 목록을 제공하여, 한 가지 옵션을 여럿 중에서 선택할 수 있게 해주는 기능입니다. 폼 입력이나 설정 선택 등에 자주 사용됩니다. Kotlin을 사용하여 Spinner를 구현하는 방법에 대해 설명하겠습니다.

Spinner 설정 및 사용
XML 레이아웃에 Spinner 추가: 먼저, 사용자 인터페이스에 Spinner를 추가하기 위해 XML 레이아웃 파일에 <Spinner> 태그를 사용합니다. Spinner에 필요한 속성들을 설정할 수 있습니다.
xml


<Spinner
    android:id="@+id/spinner"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"/>
Adapter 사용: Spinner는 Adapter를 통해 데이터를 받습니다. 대표적으로 ArrayAdapter를 사용하여 배열 데이터를 Spinner에 연결할 수 있습니다. Kotlin 코드에서 ArrayAdapter를 생성하고 Spinner에 설정합니다.
kotlin


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner: Spinner = findViewById(R.id.spinner)
        // 배열 데이터
        val options = arrayOf("옵션 1", "옵션 2", "옵션 3")

        // ArrayAdapter 생성
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Spinner에 Adapter 설정
        spinner.adapter = adapter

        // 아이템 선택 이벤트 처리
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                // 여기서 선택된 아이템 처리
                Toast.makeText(this@MainActivity, "선택된 아이템: ${options[position]}", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // 아무것도 선택되지 않았을 때의 처리
            }
        }
    }
}
아이템 선택 이벤트 처리: 사용자가 아이템을 선택할 때 동작을 정의하기 위해, onItemSelectedListener를 설정하고 onItemSelected 메소드를 오버라이드합니다. 사용자가 아이템을 선택하면, 이 메소드가 호출되며 선택된 아이템에 대한 동작을 정의할 수 있습니다.

커스텀 레이아웃: 기본적으로 Spinner는 간단한 텍스트 뷰를 사용하여 아이템을 표시하지만, android.R.layout.simple_spinner_dropdown_item 같은 안드로이드에서 제공하는 레이아웃이나 사용자가 직접 정의한 레이아웃을 사용하여 커스터마이징할 수 있습니다.

Kotlin을 사용하여 간단하게 Spinner를 구현하는 방법을 설명했습니다. Spinner는 사용자 인터페이스에서 선택 가능한 옵션을 효과적으로 제시하는 데 유용한 컴포넌트입니다.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
안드로이드에서 어댑터(Adapter)는 데이터 세트와 사용자 인터페이스 컴포넌트 사이의 다리 역할을 합니다. 주로 ListView, GridView, Spinner와 같은 뷰 그룹에서 데이터를 표시할 때 사용됩니다. 어댑터는 이러한 뷰 그룹에 데이터를 제공하고, 각 항목을 어떻게 보여줄지 결정하는 역할을 합니다.

주요 어댑터 타입
ArrayAdapter: 배열이나 List와 같은 데이터 컬렉션을 사용할 때 적합합니다. 각 항목이 단일 텍스트 뷰로 표시됩니다.
CursorAdapter: 데이터베이스 쿼리 결과인 Cursor를 사용할 때 적합합니다. 데이터베이스에서 가져온 데이터를 리스트뷰나 그리드뷰에 표시할 수 있습니다.
RecyclerView.Adapter: RecyclerView에 사용되는 어댑터로, 뷰 홀더 패턴을 사용하여 효율적으로 대량의 데이터를 표시합니다.
BaseAdapter: 직접 커스텀 어댑터를 만들고 싶을 때 사용할 수 있는 가장 기본이 되는 어댑터입니다. getView() 메소드를 오버라이드하여 각 항목의 뷰를 직접 제어할 수 있습니다.
어댑터의 주요 메서드
getCount(): 데이터 세트의 항목 수를 반환합니다.
getItem(int position): 특정 위치(position)에 있는 데이터를 반환합니다.
getItemId(int position): 특정 위치의 항목 ID를 반환합니다.
getView(int position, View convertView, ViewGroup parent): 각 항목을 위한 뷰를 생성하고 반환합니다. convertView를 재사용하여 메모리 사용을 최적화할 수 있습니다.
어댑터 사용 예시 (ArrayAdapter)
kotlin


val listView: ListView = findViewById(R.id.listview)
val dataList = listOf("항목1", "항목2", "항목3")
val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dataList)
listView.adapter = adapter
이 예제는 ListView에 ArrayAdapter를 사용하여 문자열 리스트를 표시하는 방법을 보여줍니다. simple_list_item_1은 안드로이드에서 기본적으로 제공하는 레이아웃으로, 각 항목을 단일 텍스트뷰로 표시합니다.

어댑터의 중요성
어댑터를 사용함으로써, 데이터와 UI 컴포넌트 사이의 결합도를 낮출 수 있습니다. 데이터 소스를 변경하더라도, 어댑터 내부만 수정하면 되므로 UI 코드를 재사용하기 쉽습니다. 또한, 어댑터는 데이터를 효율적으로 관리하고, 필요에 따라 데이터를 동적으로 업데이트하면서 사용자에게 표시할 수 있게 해줍니다.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
createFromResource() 메서드는 주로 ArrayAdapter와 함께 사용되며, 리소스 파일에서 데이터를 가져와 ArrayAdapter를 초기화하는 데 사용됩니다. 이 방법은 리소스(XML) 파일에 정의된 배열 데이터를 사용하여 스피너, 리스트뷰 등에 데이터를 쉽게 제공할 수 있게 해줍니다.

사용 방법
createFromResource() 메서드는 세 개의 매개변수를 받습니다:

Context: 현재 화면의 컨텍스트입니다. 대부분의 경우, 이는 Activity를 가리킵니다.
Array Resource ID: 데이터가 저장된 배열의 리소스 ID입니다. 배열은 res/values 디렉토리에 있는 XML 파일에 정의됩니다.
Dropdown View Resource ID: 스피너나 리스트뷰에서 각 항목을 표시할 때 사용할 레이아웃을 지정합니다. 안드로이드 SDK에 내장된 레이아웃(android.R.layout.simple_spinner_item 등)을 사용하거나 사용자 정의 레이아웃을 사용할 수 있습니다.
예제
res/values/strings.xml 파일에 배열을 정의합니다:

xml


<resources>
    <string-array name="planets_array">
        <item>수성</item>
        <item>금성</item>
        <item>지구</item>
        <item>화성</item>
        <item>목성</item>
        <item>토성</item>
        <item>천왕성</item>
        <item>해왕성</item>
    </string-array>
</resources>
그리고 ArrayAdapter를 사용하여 스피너에 데이터를 제공합니다:

kotlin


val spinner: Spinner = findViewById(R.id.spinner)
// ArrayAdapter.createFromResource를 사용하여 배열 리소스를 로드합니다.
val adapter = ArrayAdapter.createFromResource(
    this,
    R.array.planets_array, // 배열 리소스 ID
    android.R.layout.simple_spinner_item // 항목을 표시할 레이아웃
)
// 드롭다운 메뉴에 사용할 레이아웃을 지정합니다.
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
// 어댑터를 스피너에 설정합니다.
spinner.adapter = adapter
이 예제에서는 createFromResource() 메서드를 사용하여 strings.xml 리소스 파일에 정의된 행성 이름 배열을 스피너에 표시합니다. 이 방법은 코드 내에서 데이터를 직접 관리하지 않고도 리소스 파일을 통해 UI 요소에 데이터를 쉽게 제공할 수 있게 해줍니다.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Android에서 setOnCheckedChangeListener는 CompoundButton 클래스의 인스턴스(예: CheckBox, Switch, ToggleButton 등)에서 상태 변경(체크 또는 언체크)을 감지하는 데 사용되는 리스너입니다. 이 리스너를 사용하면 사용자가 UI 컴포넌트의 상태를 변경할 때마다 콜백을 받을 수 있어, 해당 상태 변경에 대응하는 로직을 실행할 수 있습니다.

setOnCheckedChangeListener를 사용하는 방법은 다음과 같습니다:

CompoundButton 클래스의 객체(예: CheckBox)에 setOnCheckedChangeListener 메소드를 호출하여 CompoundButton.OnCheckedChangeListener 인터페이스를 구현하는 리스너를 등록합니다.

onCheckedChanged(CompoundButton buttonView, boolean isChecked) 메소드를 오버라이드하여, 체크 상태가 변경될 때 실행할 코드를 정의합니다. 이 메소드는 체크 상태가 변경될 때마다 호출되며, isChecked 파라미터는 변경된 상태를 나타냅니다.

예를 들어, CheckBox의 체크 상태 변화를 감지하고 로그를 출력하는 간단한 예제는 다음과 같습니다:

kotlin


val checkBox: CheckBox = findViewById(R.id.checkbox)
checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
    if (isChecked) {
        // 체크 상태일 때 실행할 코드
        Log.d("CheckBox", "CheckBox is checked")
    } else {
        // 언체크 상태일 때 실행할 코드
        Log.d("CheckBox", "CheckBox is unchecked")
    }
}
이 코드는 사용자가 CheckBox를 체크하거나 언체크할 때마다 로그를 출력합니다. setOnCheckedChangeListener는 사용자의 입력에 반응하여 즉각적인 피드백을 제공하거나, 애플리케이션의 동작을 변경하는 등의 상황에 유용하게 활용될 수 있습니다.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Android의 SharedPreferences는 앱에서 사용자의 설정 값이나 간단한 데이터를 key-value 쌍으로 저장하고 관리할 수 있는 메커니즘을 제공합니다. 이는 앱의 사용자 설정, 사용자가 입력한 데이터 등을 로컬에서 지속적으로 유지해야 할 때 유용하게 사용됩니다. SharedPreferences는 앱이 종료되어도 데이터가 사라지지 않으며, 앱을 다시 시작할 때 이전에 저장된 데이터를 복원할 수 있습니다.

사용 방법
SharedPreferences 객체 얻기:
SharedPreferences 객체를 얻기 위해서는 Context 객체의 getSharedPreferences(String name, int mode) 메소드를 사용하거나, 액티비티에서 getPreferences(int mode)를 사용할 수 있습니다. name은 preferences 파일의 이름이며, mode는 파일 접근 모드를 지정합니다.

데이터 저장하기:
데이터를 저장하기 위해서는 SharedPreferences.Editor 객체를 사용해야 합니다. SharedPreferences 객체에서 edit() 메소드를 호출하여 Editor 객체를 얻은 다음, putString(), putInt(), putBoolean() 등의 메소드를 사용하여 데이터를 저장하고, apply() 또는 commit() 메소드를 호출하여 변경사항을 적용합니다. apply()는 비동기적으로 데이터를 저장하고, commit()은 동기적으로 저장합니다.

데이터 읽기:
데이터를 읽을 때는 SharedPreferences 객체에서 getString(), getInt(), getBoolean() 등의 메소드를 사용하여 저장된 데이터를 검색할 수 있습니다. 이 메소드들은 key를 인자로 받고, 해당 key에 해당하는 데이터가 없을 경우 반환할 기본값을 지정할 수 있습니다.

데이터 삭제하기:
SharedPreferences.Editor를 사용하여 특정 key의 데이터를 삭제하거나, 모든 데이터를 삭제할 수 있습니다. 특정 key의 데이터를 삭제할 때는 remove(String key) 메소드를, 모든 데이터를 삭제할 때는 clear() 메소드를 사용합니다.

예시 코드
kotlin


// SharedPreferences 객체 얻기
val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

// 데이터 저장하기
val editor = sharedPreferences.edit()
editor.putString("username", "John Doe")
editor.putInt("age", 30)
editor.apply()

// 데이터 읽기
val username = sharedPreferences.getString("username", "defaultName")
val age = sharedPreferences.getInt("age", 0)

// 데이터 삭제하기
editor.remove("username").apply()
// 또는
editor.clear().apply()
SharedPreferences는 간단한 데이터를 저장하는 데 적합하지만, 복잡한 데이터 구조나 대량의 데이터를 저장하기에는 한계가 있습니다. 이 경우, 데이터베이스 사용을 고려해야 할 수 있습니다.

SharedPreferences는 주로 다음과 같은 상황에서 사용됩니다:

1. 사용자 설정 저장: 사용자가 앱 내에서 설정한 선호도나 설정(예: 알림 설정, 테마 색상)을 저장하고 앱을 재시작할 때 이러한 설정을 복원하는 데 사용됩니다.

2. 간단한 데이터 저장: 사용자의 로그인 상태, 사용자 이름, 이메일 주소와 같은 간단한 정보를 저장하는 데 사용됩니다. 이러한 정보는 앱이 다시 시작될 때 사용자 경험을 개선하기 위해 재사용될 수 있습니다.

3. 앱의 첫 실행 확인: 앱이 처음으로 실행되었는지 여부를 확인하고, 첫 실행 시에만 특정 동작을 수행하거나 안내를 제공하는 데 사용됩니다.

4. 작은 데이터 세트의 영속성: 사용자의 성취도, 점수 또는 앱의 작은 설정 같은 소량의 데이터를 지속적으로 저장하는 데 이상적입니다.

5. 상태 유지: 앱이 사용 중이거나 백그라운드로 이동했을 때 사용자의 특정 선택이나 앱의 상태를 저장하고 복원하기 위해 사용됩니다.

SharedPreferences는 간단하고 빠르게 데이터를 저장하고 검색할 수 있는 장점이 있지만, 복잡한 데이터 구조나 대량의 데이터를 저장하기에는 적합하지 않습니다. 복잡한 데이터를 저장해야 하는 경우, SQLite 데이터베이스, Room 데이터베이스, 또는 다른 데이터 저장 방법을 고려해야 합니다.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
selectedItem의 주요 사용 사례:
항목 정보 얻기: 사용자가 AdapterView 내의 특정 항목을 선택했을 때, 그 항목에 해당하는 데이터를 얻기 위해 selectedItem 속성을 사용할 수 있습니다. 예를 들어, Spinner에서 현재 선택된 아이템의 데이터를 가져오고 싶을 때 spinner.selectedItem을 사용해 해당 데이터 객체에 접근할 수 있습니다.

선택된 항목의 위치 얻기: selectedItemPosition 속성을 사용하여 현재 선택된 항목의 위치(인덱스)를 얻을 수 있습니다. 이 정보는 배열이나 리스트에서 해당 항목을 찾을 때 유용하게 사용됩니다.

예제 코드:
kotlin


// Spinner 예제
val spinner: Spinner = findViewById(R.id.spinner)
spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
    override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
        // 현재 선택된 아이템 얻기
        val selectedItem = parent.selectedItem
        // 선택된 아이템을 활용 (예: 텍스트 표시)
        Toast.makeText(this@MainActivity, selectedItem.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // 아무것도 선택되지 않았을 때의 처리
    }
}
이 예제에서는 Spinner에서 사용자가 항목을 선택했을 때, 그 항목의 데이터를 selectedItem을 통해 얻어와 토스트 메시지로 표시하는 방법을 보여줍니다.

selectedItem과 관련된 기능은 사용자의 선택에 반응하여 특정 작업을 수행하거나, 추가 정보를 제공하는 등의 상황에서 유용하게 활용됩니다.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 const val로 선언된 상수는 컴파일 시점에 그 값이 결정되며, 런타임 시점에 변경될 수 없습니다. 이러한 특성 때문에 const val로 선언된 상수는 프로그램의 성능 향상에 기여할 수 있습니다.

const val 사용 시 주의할 점
const val은 기본 타입(예: String, Int, Float 등)의 값과 String 템플릿만을 지원합니다.
클래스의 멤버 변수로 사용할 수 없으며, 오직 object 선언이나 최상위 수준(top-level)에서만 사용할 수 있습니다.
const는 val과 함께 사용되어야 하며, var와는 함께 사용될 수 없습니다.
예제
kotlin


const val MAX_USER_COUNT = 100

object Config {
    const val BASE_URL = "https://example.com"
}

fun main() {
    println(MAX_USER_COUNT)  // 100 출력
    println(Config.BASE_URL)  // "https://example.com" 출력
}
이 예제에서 MAX_USER_COUNT는 최상위 수준에서 const val로 선언된 상수이며, Config 오브젝트 내의 BASE_URL도 마찬가지로 const val로 선언되어 있습니다. 두 상수 모두 컴파일 시점에 그 값이 결정되므로, 프로그램 내에서 고정된 값을 제공합니다.

const val을 사용함으로써 읽기 쉽고 변경할 수 없는 상수 값을 프로그램 전반에 걸쳐 안전하게 사용할 수 있으며, 이는 코드의 유지 관리성과 실행 성능을 향상시키는 데 도움이 됩니다.
