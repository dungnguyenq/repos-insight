export class Commit {
    public title : string;
    public commit_url : string;
    public created_date : Date;
    public github_username : string;
    public github_avaurl : string;
    public github_profile : string

    constructor(title : string, commit_url: string, created_date: Date, github_username : string, github_avaurl : string, github_profile : string) { 
        this.title = title
        this.commit_url = commit_url
        this.created_date = created_date
        this.github_username = github_username
        this.github_avaurl = github_avaurl
        this.github_profile = github_profile
    }
}
