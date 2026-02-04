# Java String / Map / List 자주 쓰는 메서드 (요약)

## String
- length() : 길이
- charAt(i) : i번째 문자
- substring(begin), substring(begin, end) : 부분 문자열 (end 미포함)
- contains(x) : 포함 여부
- equals(x), equalsIgnoreCase(x) : 동등 비교
- toUpperCase(), toLowerCase() : 대/소문자 변환
- trim() / strip() : 양끝 공백 제거( strip는 유니코드 공백 포함 )
- replace(a, b) : 치환(문자/문자열)
- replaceAll(regex, b) / replaceFirst(regex, b) : 정규식 기반 치환
- split(regex) : 특정 문자를 분리 -> 반환값이 String[] 임
- isEmpty() : 길이 0
- isBlank() : 공백만 있어도 true
- toCharArray() : char[]로 변환
- valueOf(x) : 문자열로 변환

## Map (주로 HashMap)
- put(k, v) : 추가/갱신
- get(k) : 조회(없으면 null)
- getOrDefault(k, def) : 기본값 포함 조회
- containsKey(k), containsValue(v) : 포함 여부
- remove(k) : 삭제
- size(), isEmpty(), clear() : 크기/비움/초기화
- putIfAbsent(k, v) : 없을 때만 추가
- keySet(), values(), entrySet() : 키/값/엔트리 뷰
- forEach((k, v) -> ...) : 순회
- computeIfAbsent(k, f) : 없으면 만들어서 넣고 반환(그룹핑 자주 씀)
- compute(k, f) / replace(k, v) : 값 재계산/치환
- merge(k, v, f) : 누적/합산(빈도수 증가에 유용)

## List (주로 ArrayList)
- add(x), add(i, x) : 추가
- get(i) : 조회
- set(i, x) : 수정
- remove(i) / remove(x) : 삭제(인덱스/값)
- size(), isEmpty() : 크기/비었는지
- contains(x) : 포함 여부
- indexOf(x), lastIndexOf(x) : 위치 찾기
- subList(from, to) : 부분 리스트(to 미포함)
- sort(cmp) : 정렬
- clear() : 전체 삭제
- toArray() : 배열로 변환

## Stack

	•	push(x) : 맨 위에 넣기
	•	pop() : 맨 위 꺼내서 제거(반환)
	•	peek() : 맨 위 값 확인(제거 X)
	•	isEmpty() : 비었는지
	•	size() : 원소 개수
	•	clear() : 전체 비우기
	•	search(x) : 위에서부터 몇 번째인지(없으면 -1)
	•	contains(x) : 포함 여부 (Stack은 Vector 상속이라 가능)
	•	get(i) : i번째 원소 조회(스택답진 않지만 가끔 디버깅/특수케이스에 씀)

※ 코테 팁: 스택처럼 쓸 거면 Deque(예: ArrayDeque)로도 많이 함 (push/pop/peek 동일 이름 지원).

## Array (배열)

### 기본
- length : 배열 길이 (필드, 메서드 아님)
- arr[i] : i번째 요소 접근
- Arrays.toString(arr) : 배열을 문자열로 출력(디버깅용)
- Arrays.equals(a, b) : 배열 내용 비교
- Arrays.copyOf(arr, n) : 길이 n으로 복사
- Arrays.copyOfRange(arr, from, to) : 구간 복사(to 미포함)
- arr.clone() : 얕은 복사(1차원은 실사용 OK)

### 정렬 / 탐색
- Arrays.sort(arr) : 오름차순 정렬
- Arrays.sort(arr, from, to) : 부분 정렬
- Arrays.binarySearch(arr, x) : 이진 탐색(정렬된 상태 필수)

### 채우기 / 초기화
- Arrays.fill(arr, x) : 전체를 x로 채움
- Arrays.fill(arr, from, to, x) : 구간 채우기

### 다차원 배열
- Arrays.deepToString(arr) : 다차원 배열 출력
- Arrays.deepEquals(a, b) : 다차원 배열 비교

※ 코테 팁:
- primitive 배열은 null 체크보다 범위 체크가 중요
- Arrays.binarySearch는 음수 반환 규칙 주의
- 2차원 이상에서 clone()은 얕은 복사이므로 직접 복사 필요