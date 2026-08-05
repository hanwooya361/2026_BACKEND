package test;

import java.util.Scanner;

class Post{
    String content;
    String writer;
    Post(){}
    public Post(String content, String writer) {
        this.content = content;
        this.writer = writer;
    }
    
}

public class OverallController {
    Post[] posts = new Post[100];
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        OverallController controller = new OverallController();
        for(;;){
            System.out.println("========커뮤니티========");
            System.out.println("1.게시물쓰기 2.게시물출력");
            System.out.println("========================");
            System.out.print("선택>");
            int ch = scanner.nextInt();

            if(ch==1){
                scanner.nextLine();
                System.out.print("내용: ");
                String content = scanner.nextLine();
                System.out.print("작성자: ");
                String writer = scanner.nextLine();
                Post post = new Post(content, writer);
                boolean result = false;
                
                for(int i=0; i<controller.posts.length; i++){
                    if(controller.posts[i]==null){
                        controller.posts[i] = post;
                        result = true;
                        break;
                    }
                }
                if(result){
                    System.out.println("글쓰기 성공");
                }else{
                    System.out.println("글쓰기 실패");
                }
            }else if(ch==2){
                for(Post post : controller.posts){
                    if(post != null){
                        System.out.printf("내용:%s 작성자:%s\n", post.content, post.writer);
                    }
                }
            }
        }
        
    }
}
