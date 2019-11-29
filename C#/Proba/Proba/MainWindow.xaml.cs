using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Data.SqlClient;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Proba
{
    /// <summary>
    /// Logika interakcji dla klasy MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        int deptno { get; set; }
        private EmployeeGrid employ { get; set; }
        public List<string> DnameBox { get; set; }

        public static ObservableCollection<EmployeeGrid> listaPracownikow;
        public static ObservableCollection<EmployeeGrid> listaSzukanychPracownikow { get; set; }

        public ObservableCollection<EmployeeGrid> ListaPracownikow
        {
            get { return listaPracownikow; }
            set
            {
                if (value != listaPracownikow)
                {
                    listaPracownikow = value;
                }
            }
        }

        public MainWindow()
        {
            InitializeComponent();
            DnameBox = new List<string>();
            LoadDatatoTextBoxAndDataGrid();
            DataContext = this;
            
        }

        private void LoadDatatoTextBoxAndDataGrid()
        {
            ListaPracownikow = new ObservableCollection<EmployeeGrid>();

            LoadEmployees();
            EmployeeGrid.ItemsSource = ListaPracownikow;
            IdCounter = 0;
        }

        public void LoadEmployees()
        {
            using (var con = new SqlConnection("Data Source=db-mssql16.pjwstk.edu.pl;Initial Catalog=s15269;Integrated Security=True"))
            using (var comm = new SqlCommand())
            {
                comm.Connection = con;
                comm.CommandText = "SELECT E.Ename, E.JOB, D.DNAME FROM s15269.apbd.EMP E, s15269.apbd.DEPT D WHERE E.DEPTNO = D.DEPTNO;";

                con.Open();
                using (SqlDataReader dr = comm.ExecuteReader())
                {
                    var list = new List<EmployeeGrid>();
                    while (dr.Read())
                    {
                        string ename = dr["Ename"].ToString();
                        string job = dr["Job"].ToString();
                        string dname = dr["Dname"].ToString();
                        if (!DnameBox.Contains(dname))
                        {
                            DnameBox.Add(dname);
                        }
                        
                        listaPracownikow.Add(new EmployeeGrid
                            {
                                Ename = ename,
                                Job = job,
                                Dname = dname
                            });
                    }
                }
            }
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            ListaPracownikow.Clear();
            listaPracownikow.Clear();
            using (var con = new SqlConnection("Data Source=db-mssql16.pjwstk.edu.pl;Initial Catalog=s15269;Integrated Security=True"))
            using (var comm = new SqlCommand())
            {
                comm.Connection = con;
                comm.CommandText = "SELECT E.Ename, E.JOB, D.DNAME FROM s15269.apbd.EMP E, s15269.apbd.DEPT D WHERE E.DEPTNO = D.DEPTNO AND E.ENAME = '" + textBox_Szukaj.Text + "';";

                con.Open();
                using (SqlDataReader dr = comm.ExecuteReader())
                {
                    var list = new List<EmployeeGrid>();
                    while (dr.Read())
                    {
                        string ename1 = dr["Ename"].ToString();
                        string job1 = dr["Job"].ToString();
                        string dname1 = dr["Dname"].ToString();


                        listaPracownikow.Add(new EmployeeGrid
                        {
                            Ename = ename1,
                            Job = job1,
                            Dname = dname1
                        });
                    }
                }
            }
            EmployeeGrid.ItemsSource = listaPracownikow;
            IdCounter = 0;
        }

        private void EmployeeGrid_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            IdCounter = 0;
        }


        private int count;
        public int IdCounter
        {
            get
            {
                return count;
            }
            set
            {

                if (count != EmployeeGrid.SelectedItems.Count)
                {
                    count = EmployeeGrid.SelectedItems.Count;
                    OnPropertyChanged("IdCounter");
                }
            }

        }


        public event PropertyChangedEventHandler PropertyChanged;
        protected void OnPropertyChanged([CallerMemberName] String propertyName = "")
        {
            PropertyChangedEventHandler handler = PropertyChanged;
            if (handler != null)
            {
                handler(this, new PropertyChangedEventArgs(propertyName));
            }
        }

        public void NotifyPropertyChanged([CallerMemberName] String propertyName = "")
        {
            if (PropertyChanged != null)
            {
                PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
            }
        }

        private void Dodaj_Click(object sender, RoutedEventArgs e)
        {
            Regex reg = new Regex(@"^[a-zA-Z]+$");
            Match match = reg.Match(textBox_Ename.Text);
            Match match2 = reg.Match(textBox_job.Text);

            if (match.Success &&
                match2.Success &&
                textBox_Ename.Text.Length >= 3 &&
                textBox_job.Text.Length >= 3 &&
                comboBox_Dname.SelectedItem != null)
            {

                listaPracownikow.Add(new EmployeeGrid
                {
                    Ename = textBox_Ename.Text,
                    Job = textBox_job.Text,
                    Dname = comboBox_Dname.Text
                });

                OnPropertyChanged();

                if (comboBox_Dname.Text.Equals("Piekarnia"))
                {
                    deptno = 3;
                } else if (comboBox_Dname.Text.Equals("Korporacja"))
                {
                    deptno = 4;
                } else if (comboBox_Dname.Text.Equals("Restaruracja"))
                {
                    deptno = 5;
                }

                    using (var con = new SqlConnection("Data Source=db-mssql16.pjwstk.edu.pl;Initial Catalog=s15269;Integrated Security=True"))
                    using (var comm = new SqlCommand())
                {
                    comm.Connection = con;
                    comm.CommandText = "INSERT INTO s15269.apbd.EMP(EMPNO, ENAME, JOB, DEPTNO) VALUES("+ (count + 10) + ", '" + textBox_Ename.Text + "', '" + textBox_job.Text + "', " + deptno + ");";

                    con.Open();
                    comm.ExecuteNonQuery();
                    con.Close();
                }
                IdCounter = 0;
            }
            else
            {
                MessageBox.Show("Nieprawidlowo uzupełnione pola!");
            }
        }

        private void Pokaz_Click(object sender, RoutedEventArgs e)
        {
            LoadDatatoTextBoxAndDataGrid();
        }
    }
}
