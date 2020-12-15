export class Committer {
    public display_name: string 
    public email: string
    public github_username: string
    public github_avaurl: string
    public github_profile: string
    public commit_count: any

    constructor(display_name: string, email: string, github_username: string, github_avaurl: string, github_profile: string, commit_count: any ){
        this.display_name = display_name
        this.email = email
        this.github_username = github_username
        this.github_avaurl = github_avaurl
        this.github_profile = github_profile
    }
}
