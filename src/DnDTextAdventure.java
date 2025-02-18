import java.util.Random;
import java.util.Scanner;

class Character {
    String name;
    int strength, dexterity, intelligence, health;

    public Character(String name, int strength, int dexterity, int intelligence, int health) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.health = health;
    }
}

public class DnDTextAdventure {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("欢迎来到中世纪文字冒险游戏！请输入您的角色名称：");
        String name = scanner.nextLine();

        Character player = new Character(name, rollStat(), rollStat(), rollStat(), 100);
        System.out.println("角色创建成功！\n" + "名称: " + player.name + "\n力量: " + player.strength + "\n敏捷: " + player.dexterity + "\n智力: " + player.intelligence);

        startAdventure(player);
    }

    private static int rollStat() {
        return random.nextInt(10) + 8; // 生成 8-18 之间的随机属性
    }

    private static void startAdventure(Character player) {
        System.out.println("你站在一个分岔路口，左边是阴暗的森林，右边是一条通向城镇的小路。你选择：");
        System.out.println("1. 进入森林\n2. 前往城镇");

        int choice = scanner.nextInt();
        scanner.nextLine();
        
        if (choice == 1) {
            forestPath(player);
        } else {
            townPath(player);
        }
    }

    private static void forestPath(Character player) {
        System.out.println("你走进了森林，发现了一只狼！");
        if (combat(player, 12)) {
            System.out.println("你击败了狼，找到了宝藏！");
        } else {
            System.out.println("你被狼打败了，游戏结束！");
        }
    }

    private static void townPath(Character player) {
        System.out.println("你到达了城镇，被一名神秘男子邀请进入酒馆。他看起来很友好……");
        System.out.println("1. 跟随他进入酒馆\n2. 拒绝并离开");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.println("你被下了药，醒来后发现自己被关在地牢里，游戏结束！");
        } else {
            System.out.println("你谨慎地离开了城镇，继续你的冒险。");
        }
    }

    private static boolean combat(Character player, int enemyStrength) {
        int roll = random.nextInt(20) + 1 + player.strength;
        return roll >= enemyStrength;
    }
}
