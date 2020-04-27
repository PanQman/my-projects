
using DeansOffice1.DAL;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Collections.Specialized;
using System.ComponentModel;
using System.Data.SqlClient;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
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

namespace DeansOffice1
{
    /// <summary>
    /// Logika interakcji dla klasy MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window, INotifyPropertyChanged
    {
        public static ObservableCollection<StudentsDbService> listaStudentow;
        public  ObservableCollection<StudentsDbService> ListaStudentow
        {
            get { return listaStudentow; }
            set
            {
                if (value != listaStudentow)
                {
                    listaStudentow = value;
                }
            }
        }

        public MainWindow()
        {

            InitializeComponent();
            LoadDatatoTextBoxAndDataGrid();
            DataContext = this;
            
        }

        private void LoadDatatoTextBoxAndDataGrid()
        {
            ListaStudentow = new ObservableCollection<StudentsDbService>();
            
            LoadStudents();
            StudentsDataGrid.ItemsSource = ListaStudentow;
            IdCounter = 0;
        }

        private void StudentsDataGrid_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            IdCounter = 0;
        }

        public void deleteStudent()
        {
            using (var con = new SqlConnection("Data Source=db-mssql16.pjwstk.edu.pl;Initial Catalog=s15269;Integrated Security=True"))
            using (var comm = new SqlCommand())
            {
                comm.Connection = con;

                comm.CommandText = "DELETE FROM s15269.apbd.Student WHERE IndexNumber =";
            }
        }

        public void LoadStudents()
        {
            using (var con = new SqlConnection("Data Source=db-mssql16.pjwstk.edu.pl;Initial Catalog=s15269;Integrated Security=True"))
            using (var comm = new SqlCommand())
            {
                comm.Connection = con;
                comm.CommandText = "SELECT S.IdStudent, S.FirstName, S.LastName, S.IndexNumber, S.Address, ST.Name FROM s15269.apbd.Student S, s15269.apbd.Studies ST WHERE S.IdStudies = ST.IdStudies;";

                con.Open();
                using (SqlDataReader dr = comm.ExecuteReader())
                {
                    var list = new List<StudentsDbService>();
                    while (dr.Read())
                    {

                        string imie = dr["FirstName"].ToString();
                        string nazwisko = dr["LastName"].ToString();
                        string nrIndeksu = dr["IndexNumber"].ToString();
                        string adres = dr["Address"].ToString();
                        string studia = dr["Name"].ToString();

                        if (dr["IdStudent"] != DBNull.Value)
                        {
                            int idOsoba = (int)dr["IdStudent"];

                            ListaStudentow.Add(new StudentsDbService
                            {
                                Nazwisko = nazwisko,
                                Imie = imie,
                                NrIndeksu = nrIndeksu,
                                Adres = adres,
                                Studia = studia
                            });
                        }
                    }
                }
            }
        }

        private void Usun_Click(object sender, RoutedEventArgs e)
        {

            if (MessageBox.Show("Czy na pewno chcesz usunąć dane studentów ?", "", 
                MessageBoxButton.YesNo) == MessageBoxResult.Yes)
            {
                while (StudentsDataGrid.SelectedItems.Count > 0)
                {
                    StudentsDbService sdb = (StudentsDbService)StudentsDataGrid.SelectedItem;
                    ListaStudentow.RemoveAt(StudentsDataGrid.SelectedIndex);
                    string index = sdb.NrIndeksu;

                    using (var con = new SqlConnection("Data Source=db-mssql16.pjwstk.edu.pl;Initial Catalog=s15269;Integrated Security=True"))
                    using (var comm = new SqlCommand())
                    {
                        comm.Connection = con;
                        comm.CommandText = "DELETE FROM s15269.apbd.Student WHERE IndexNumber = " + index;

                        con.Open();
                        comm.ExecuteNonQuery();
                        con.Close();
                    }
                }
                IdCounter = 0;
            }
        }
        private void Dodaj_Click(object sender, RoutedEventArgs e)
        {
            var win1 = new Window1();
            win1.ShowDialog();
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
                
                if (count != StudentsDataGrid.SelectedItems.Count)
                {
                   count = StudentsDataGrid.SelectedItems.Count;
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

        private void StudentsDataGrid_MouseDoubleClick(object sender, MouseButtonEventArgs e)
        {
            StudentsDbService sd = (StudentsDbService)StudentsDataGrid.SelectedItem;
            var edyt = new Edycja(sd);
            edyt.ShowDialog();
            if (!edyt.IsActive)
            {
                ListaStudentow.Add(sd);
                ListaStudentow.Remove(sd);
            }
            
        }
    }
}
