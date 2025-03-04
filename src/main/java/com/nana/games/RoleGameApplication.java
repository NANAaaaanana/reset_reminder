package com.nana.games;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nana.enums.RoleEvent;
import com.nana.enums.RoleState;

@SpringBootApplication
public class RoleGameApplication {

    @Autowired
    private RoleGameService roleGameService;

    public static void main(String[] args) {
        SpringApplication.run(RoleGameApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("当前角色状态: " + roleGameService.getCurrentState());
                System.out.println("请选择动作 (1: 劳动, 2: 娱乐, 3: 吃饭, 0: 退出): ");
                int choice = scanner.nextInt();
                if (choice == 0) {
                    break;
                }
                RoleEvent event;
                switch (choice) {
                    case 1:
                        event = RoleEvent.WORK;
                        break;
                    case 2:
                        event = RoleEvent.ENTERTAINMENT;
                        break;
                    case 3:
                        event = RoleEvent.EAT;
                        break;
                    default:
                        System.out.println("无效的选择，请重新输入。");
                        continue;
                }
                RoleState newState = roleGameService.performAction(event);
                System.out.println("新的角色状态: " + newState);
            }
            scanner.close();
        };
    }
}
