import java.util.HashSet;
import java.util.Objects;

class Solution {

    // 2배 스케일링된 좌표를 저장하기 위한 Point 클래스
    private static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // HashSet에서 동일한 점인지 비교하기 위해 hashCode와 equals 오버라이딩
        @Override
        public int hashCode() {
            // 좌표값을 이용해 고유한 해시코드 생성 (충돌 가능성 낮춤)
            // x, y 범위가 충분히 크므로 적절한 상수를 곱해 분리
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Point point = (Point) obj;
            return x == point.x && y == point.y;
        }
    }

    // 두 점 사이의 간선(선분)을 저장하기 위한 Edge 클래스
    // 간선은 방향성이 없으므로 두 점의 순서가 달라도 동일한 간선으로 취급해야 함
    private static class Edge {
        Point p1, p2;

        Edge(Point p1, Point p2) {
            // hashCode와 equals에서 일관성을 유지하기 위해
            // 항상 좌표값이 작은 점을 p1으로 오도록 정렬
            if (p1.x > p2.x || (p1.x == p2.x && p1.y > p2.y)) {
                this.p1 = p2;
                this.p2 = p1;
            } else {
                this.p1 = p1;
                this.p2 = p2;
            }
        }

        // HashSet에서 동일한 간선인지 비교하기 위해 hashCode와 equals 오버라이딩
        @Override
        public int hashCode() {
            // 두 점의 해시코드를 조합하여 간선의 해시코드 생성
            return Objects.hash(p1, p2);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Edge edge = (Edge) obj;
            // 정렬된 p1, p2를 비교하므로 순서에 상관없이 동일 간선 판별 가능
            return Objects.equals(p1, edge.p1) && Objects.equals(p2, edge.p2);
        }
    }

    public int solution(int[] arrows) {
        int roomCount = 0; // 생성된 방의 개수

        // 방문한 노드(점)들을 저장하는 HashSet
        HashSet<Point> visitedNodes = new HashSet<>();
        // 방문한 간선(선분)들을 저장하는 HashSet
        HashSet<Edge> visitedEdges = new HashSet<>();

        // 8방향 이동에 대한 델타값 (2배 스케일링 적용)
        // 0:상, 1:우상, 2:우, 3:우하, 4:하, 5:좌하, 6:좌, 7:좌상
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {1, 1, 0, -1, -1, -1, 0, 1}; // 좌표계 기준 (y가 위로 증가) -> 문제 기준으로는 dy={1...} 이 맞지만, 스케일링 후 중간점/끝점 이동을 2번 하므로 결과적으로 동일

        // 시작점 (0, 0) 추가
        Point current = new Point(0, 0);
        visitedNodes.add(current);

        for (int arrow : arrows) {
            // 각 화살표 방향으로 2번 이동 (중간점, 최종점)
            for (int i = 0; i < 2; i++) {
                // 다음 이동할 점 계산 (스케일링된 값 사용)
                int nextX = current.x + dx[arrow];
                int nextY = current.y + dy[arrow];
                Point next = new Point(nextX, nextY);

                // 현재점과 다음점 사이의 간선 생성
                Edge edge = new Edge(current, next);

                // 방 생성 조건 확인
                // 1. 다음 노드가 이미 방문한 노드인가?
                // 2. 그런데 이 간선은 처음 지나가는 간선인가?
                // => 이 두 조건을 모두 만족하면 새로운 방이 생성된 것
                if (visitedNodes.contains(next) && !visitedEdges.contains(edge)) {
                    roomCount++;
                }
                // 대각선 교차로 인한 방 생성 확인
                // 현재 이동이 대각선(arrow가 홀수)이고,
                // i가 0일 때 (즉, 시작점 -> 중간점으로 이동할 때)만 확인
                // A -> B 로 이동할 때, 이미 C -> D 간선이 존재하고, B == D 이고 A == C 이면 방 생성
                // 이 경우는 위 if 문에서 이미 걸러짐
                // 추가 확인: A -> B 이동시, C -> D 가 이미 존재하고 A == D 이고 B == C 인 경우 (즉, 반대방향 대각선 교차)
                // 이 경우는 2배 스케일링으로 중간점이 생기면서 위 if 조건으로 자연스럽게 걸러짐
                // --- 따라서 대각선 교차를 위한 별도 로직은 사실상 필요 없음 ---
                // (주석 처리된 아래 로직은 불필요함)
                /*
                else if (i == 0 && (arrow % 2 != 0)) { // 대각선 이동의 첫 번째 단계(시작점->중간점) 일 때
                    Point crossPrev = new Point(current.x + dx[(arrow + 7) % 8], current.y + dy[(arrow + 7) % 8]); // 반시계방향 인접 대각선 시작점
                    Point crossNext = new Point(current.x + dx[(arrow + 1) % 8], current.y + dy[(arrow + 1) % 8]); // 시계방향 인접 대각선 시작점
                    Edge crossEdge1 = new Edge(crossPrev, next); // 교차 가능 간선 1
                    Edge crossEdge2 = new Edge(crossNext, next); // 교차 가능 간선 2
                    if(visitedEdges.contains(crossEdge1) || visitedEdges.contains(crossEdge2)){
                         // 이 로직은 next 노드가 이미 방문되었을 때 위 if 문에서 처리되므로 중복됨
                        // if(!visitedEdges.contains(edge)) roomCount++; // 현재 간선이 처음일 때만 방 추가
                    }
                }
                */


                // 다음 노드와 현재 간선을 방문 목록에 추가
                visitedNodes.add(next);
                visitedEdges.add(edge);

                // 현재 위치를 다음 위치로 업데이트
                current = next;
            }
        }

        return roomCount;
    }
}