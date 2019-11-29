namespace Proba
{
    public class EmployeeGrid
    {


        public string Ename { get; set; }
        public string Job { get; set; }
        public string Dname { get; set; }

        public override string ToString()
        {
            return $"{Ename} {Job} {Dname}";
        }
    }
}