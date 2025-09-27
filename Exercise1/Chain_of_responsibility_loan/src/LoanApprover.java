public interface LoanApprover {
    void setNextApprover(LoanApprover next);
    void approveLoan(LoanApplication loan);
}
