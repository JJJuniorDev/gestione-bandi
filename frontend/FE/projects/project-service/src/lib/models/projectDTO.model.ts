export class ProjectDTO {
  constructor(
    public id: string,
    public title: string,
    public description: string,
    public startDate: Date,
    public endDate: Date,
    public status: string,
    public userId: string
  ) {}
}
