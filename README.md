# studyJava


## EOF (End of File)
- 데이터 소스로부터 더 이상 읽을 수 있는 데이터가 없음 을 나타내는 용어
- 알고리즘 문제에서 입력 값을 얼마나 받을지 명시하지 않을 경우 사용

#### Scanner클래스의 eof
```
Scanner sc = new Scanner(System.in);

while(sc.hasNext()) {
  System.out.println(sc.nextLine());
}
```

#### BufferedReader클래스의 eof
```
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String input = "";

while((input = br.readLine()) != null) {
  // 정수형으로 받는다면
  int n = Integer.parseInt(input);
}
```
