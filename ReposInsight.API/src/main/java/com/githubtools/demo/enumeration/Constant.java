package com.githubtools.demo.enumeration;

public class Constant {

    public class GithubAPI{
        public static final String	GITHUB_API_ENDPOINT = " https://api.github.com";
        public static final String  ELASTIC_SEARCH_REPO = "/repos/elastic/elasticsearch";
        public static final String	LIST_COMMITS = GITHUB_API_ENDPOINT + ELASTIC_SEARCH_REPO + "/commits";
        public static final String  LIST_COMMITS_WITH_TIME = LIST_COMMITS + "?since=%s&until=%s&per_page=%d&page=%d";

        public static final String  LIST_LANGUAGES = GITHUB_API_ENDPOINT + ELASTIC_SEARCH_REPO + "/languages";
    }

    public class GithubPara{
        public static final int PER_PAGE = 100;
    }

    public class RunType{
        public static final int AUTOMATICALLY = 0;
        public static final int MANUALLY = 1;
    }
}

