#!/bin/bash

# [설정] 실행할 메인 클래스 이름 (파일 이름이 다르면 여기를 수정하세요)
MAIN_CLASS="Main"

# 1. 기존 .class 파일 삭제 (이전 컴파일 잔재 제거)
rm -f *.class

# 2. 현재 폴더의 모든 자바 파일 컴파일
echo "🚀 Compiling..."
javac *.java

# 3. 컴파일 성공 여부 확인 ($?는 바로 앞 명령의 결과값. 0이면 성공)
if [ $? -eq 0 ]; then
    echo "✅ Build Successful! Running..."
    echo "=========================================="
    
    # 4. 자바 실행
    java $MAIN_CLASS
    
    echo "=========================================="

	# 5. .class 파일 삭제
	rm -f *.class
else
    echo "❌ Build Failed! Please check your code."
fi
