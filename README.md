# SOPT_MyApplication2
# 1주차 새로 알게된점 정리
## kotlin
### <액티비티 생명주기>
1. onCreate(): 액티비티 생성시 처음 호출되는 부분
2. onStart(): 화면이 처음으로 사용자에게 보여질 때
3. onResume(): 화면이 맨 앞에 보여질 때
4. onPause(): 사용자가 화면을 떠날 조짐이 보일 때
5. onStop(): 화면이 더이상 보이지 않을 때
6. onDestroy(): 화면이 완전히 끝나기전
->  아직 무슨말인지 잘 모르겠지만 하나씩 쓸때마다 생각해봐야겠다

### <새로 알게된 부분>
- Toast: 알림창 띄울 수 있음
- Intent기능으로 화면간 연결을 할 수 있다
  -startActivity()로 넘어갈 수 있다
  -startActivityForResult()로 다른 activity로 넘어갔다가 값을 돌려받을 수 있다


## xml
### <view와 viewgroup>
-viewgroup은 자식으로 뷰와 뷰그룹을 가질 수 있다
-view는 자식을 가질 수 없고 종류에는 ConstraintLayout, LinearLayout, RelativeLayout 등이 있다

### <레이아웃 종류>
1. ConstaintLayout
- 가로와 세로 모두 상대적 제약조건이 걸려있어야 한다
- 여백은 margin으로 준다
- 중앙에 위치시키기 위해서는 양쪽으로 제약주기
- match_constraint==0dp
- chain, guideline을 이용해 올 위치 정해줄 수 있다

2. LinearLayout
- orientation의 종류는 horizontal(이게 default)과 vertical이 있다

3. RelativeLayout
- 상대적 위치를 지정하는 방법이다
- id값을 이용해 위치를 지정한다

### <새로 알게된 부분>
- 한줄 입력제한과 비밀번호에 "*" 표시는 inputtype을 이용해 정한다
- constraintDimentionRatio 이용해서 비율을 설정할 수 있다
