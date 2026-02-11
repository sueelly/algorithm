# 10808번 알파벳 개수 - 코드 리뷰

## 📝 내 Solution.java 분석

```java
public String solve(String s) {
    int[] counts = new int[26];
    StringBuffer sb = new StringBuffer();
    
    for (char c : s.toCharArray()) {
        counts[c - 'a']++;
    }
    for (int i = 0; i < 26; i++) {
        sb.append(counts[i] + " ");
    }
    return sb.toString();
}
```

### 접근 방식
- **카운팅 배열** 사용 (길이 26)
- 각 문자에서 `'a'`를 빼서 0-25 인덱스로 변환
- `StringBuffer`로 결과 문자열 생성

### 시간 복잡도
- **O(N)** - 문자열 길이만큼 순회
- 출력 부분은 O(26) = O(1)

### 공간 복잡도
- **O(1)** - 고정 크기 배열 (26개)

### 장점 ✅
1. 직관적이고 이해하기 쉬운 코드
2. 최적의 시간 복잡도 O(N)
3. `toCharArray()`로 깔끔한 순회

### 개선 가능한 점 💡
1. `StringBuffer` → `StringBuilder` (단일 스레드에서 더 빠름)
2. `counts[i] + " "` → `counts[i]` 후 조건부 공백 (마지막 공백 제거)

---

## 🏆 대표 풀이

### 방법 1: StringBuilder 사용 (권장)
```java
public String solve(String s) {
    int[] count = new int[26];
    
    for (int i = 0; i < s.length(); i++) {
        count[s.charAt(i) - 'a']++;
    }
    
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 26; i++) {
        sb.append(count[i]);
        if (i < 25) sb.append(" ");
    }
    return sb.toString();
}
```

### 방법 2: int[] 반환 (더 순수한 로직)
```java
public int[] solve(String s) {
    int[] count = new int[26];
    
    for (char c : s.toCharArray()) {
        count[c - 'a']++;
    }
    
    return count;
}
```

### 내 코드와의 차이점
| 항목 | 내 코드 | 대표 풀이 |
|------|---------|----------|
| 문자열 빌더 | StringBuffer | StringBuilder |
| 마지막 공백 | 있음 | 없음 (조건 처리) |
| 핵심 로직 | 동일 | 동일 |

**결론**: 핵심 알고리즘은 동일! `StringBuffer` → `StringBuilder` 변경만 고려하면 됨.

---

## 🎯 다음에 시도해볼 것

### 이 문제에서 배울 점
1. **카운팅 배열** - 알파벳/숫자 개수 셀 때 자주 사용
2. **문자 → 인덱스 변환** - `c - 'a'` 패턴
3. **StringBuilder vs StringBuffer** - 단일 스레드에서는 StringBuilder가 빠름

### 보완할 점
- `StringBuffer` 대신 `StringBuilder` 사용 습관 들이기
- 출력 형식 꼼꼼히 확인 (마지막 공백 유무)

### 관련 문제 추천
| 문제 | 난이도 | 유형 |
|------|--------|------|
| [2577번: 숫자의 개수](https://www.acmicpc.net/problem/2577) | 브론즈 2 | 카운팅 배열 |
| [1157번: 단어 공부](https://www.acmicpc.net/problem/1157) | 브론즈 1 | 알파벳 카운팅 + 최댓값 |
| [10809번: 알파벳 찾기](https://www.acmicpc.net/problem/10809) | 브론즈 2 | 알파벳 위치 |
| [11655번: ROT13](https://www.acmicpc.net/problem/11655) | 브론즈 1 | 문자 변환 |

### 도전 과제
- [ ] 대소문자 구분 없이 카운팅하도록 수정해보기
- [ ] HashMap으로 구현해보기 (비교용)
- [ ] Stream API로 구현해보기

---

📅 리뷰 일자: 2026-02-11
✅ 결과: 정답
