public class EmprestimoDAOTest {
    private EntityManager em;
    private EmprestimoDAO dao;

    @Before
    public void setup() {
        this.em = JPAUtil.getEntityManager(); // Classe utilitária hipotética
        this.dao = new EmprestimoDAO(em);
        em.getTransaction().begin();
    }

    @Test
    public void testeCicloDeVidaEmprestimo() {
        // Inclusão e Consulta por ID
        Emprestimo emp = new Emprestimo();
        emp.setDataEmprestimo(new Date());
        dao.salvar(emp);
        assertNotNull(dao.buscarPorId(emp.getId()));

        // Alteração
        emp.setDataDevolucao(new Date());
        dao.atualizar(emp);
        assertEquals(emp.getDataDevolucao(), dao.buscarPorId(emp.getId()).getDataDevolucao());

        // Consulta Todos e por Nome
        assertFalse(dao.buscarTodos().isEmpty());
        
        // Exclusão
        dao.excluir(emp);
        assertNull(dao.buscarPorId(emp.getId()));
    }

    @After
    public void tearDown() {
        em.getTransaction().rollback(); // Mantém o banco limpo após os testes
        em.close();
    }
}