/**
 * NoraRobot generated free by NoraUi Organization https://github.com/NoraUi
 * NoraRobot is licensed under the license BSD.
 * 
 * CAUTION: NoraRobot use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 */
package com.axel.orange.indus;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.axel.orange.utils.NoraRobotContext;

import com.github.noraui.indus.MavenRunCounter;
import com.github.noraui.utils.Context;

public class Counter {

    public static void main(String[] args) {
        List<String> manager = new ArrayList<>();

        List<String> scenarioBlacklist = new ArrayList<>();
        // scenarioBlacklist.add("---  you can add not run scenario here ---");

        List<String> versionControlSystemsBlacklist = new ArrayList<>();
        versionControlSystemsBlacklist.add(".svn");

        NoraRobotContext.getInstance().initializeEnv("NoraRobot.properties");

        MavenRunCounter mavenRunCounter = new MavenRunCounter();
        List<MavenRunCounter.Counter> counters = mavenRunCounter.count(versionControlSystemsBlacklist, scenarioBlacklist, manager, new File(Context.getResourcesPath() + "/steps"));
        mavenRunCounter.print(counters, args[0]);
    }

}
