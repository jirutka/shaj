package com.cenqua.shaj;

import com.cenqua.shaj.log.Log;
import com.cenqua.shaj.log.PrintStreamLog;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 */
public class ManualShajTester {
    private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        int argc = args.length;
        String domain = null;
        String user = null;
        String group = null;
        String passwd = null;

        if (argc >= 1) {
            domain = args[0];
        }
        if (argc >= 2) {
            user = args[1];
        }
        if (argc >= 3) {
            group = args[2];
        }
        if (argc >= 4) {
            passwd = args[3];
        }

        if (user == null) {
            user = prompt("username:");
        }
        if (group == null) {
            group = prompt("group:");
        }
        if (passwd == null) {
            passwd = prompt("password:");
        }

        Log.Factory.setInstance(new PrintStreamLog(System.out, true));
        if (!Shaj.init()) {
            System.out.println("failed to init");
            return;
        }

        System.out.println("password check: " + Shaj.checkPassword(domain, user, passwd));
        System.out.println("group check: " + Shaj.checkGroupMembership(domain, user, group));
    }

    private static String prompt(String prompt) throws IOException {
        System.out.println(prompt);
        return stdin.readLine().trim();
    }
}
